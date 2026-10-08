package com.myopd.opd.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myopd.opd.dao.MedicineDao;
import com.myopd.opd.dto.LocationsDetailsDTO;
import com.myopd.opd.dto.medicine.ExpiringMedicinesDTO;
import com.myopd.opd.dto.medicine.MedicineDTO;
import com.myopd.opd.dto.medicine.MedicineDetailsDTO;
import com.myopd.opd.dto.medicine.NearingOutOfStockDTO;
import com.myopd.opd.dto.medicine.PurchaseOrderMedicineDTO;
import com.myopd.opd.dto.medicine.PurchaseOrderWrapper;
import com.myopd.opd.entity.Medicine;
import com.myopd.opd.exception.InsufficientStockException;
import com.myopd.opd.mapper.MedicineMapper;
import com.myopd.opd.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	private final MedicineDao medicineDao;
	private final MedicineMapper medicineMapper;

	@Autowired
	private MedicineRepository medicineRepository;

	@Autowired
	ConfigurationService configurationService;

	public MedicineServiceImpl(MedicineDao medicineDao, MedicineMapper medicineMapper) {
		this.medicineDao = medicineDao;
		this.medicineMapper = medicineMapper;

	}

	@Override
	public List<PurchaseOrderWrapper> getAllMedicines() {

		List<PurchaseOrderWrapper> purchaseOrderWrapperList = new ArrayList<>();
		List<PurchaseOrderMedicineDTO> list = medicineRepository.getAllMedicinesforPurchaseOrder();

		list.sort(Comparator.comparing(PurchaseOrderMedicineDTO::getCompanyName));
		Map<String, List<PurchaseOrderMedicineDTO>> medicinesMap = list.stream()
				.collect(Collectors.groupingBy(p -> new String(p.getMedicineName())));

		for (var entry : medicinesMap.entrySet()) {
			purchaseOrderWrapperList.add(new PurchaseOrderWrapper(entry.getKey(), entry.getValue()));

		}
		Collections.sort(purchaseOrderWrapperList, (o1, o2) -> (o1.getMedicineName().compareTo(o2.getMedicineName())));

		return purchaseOrderWrapperList;

	}

	@Override
	public List<ExpiringMedicinesDTO> getAllExpiringMedicines() {

		List<ExpiringMedicinesDTO> medicines = medicineRepository.getAllExpiringMedicines();
		return medicines;
	}

	@Override
	public List<NearingOutOfStockDTO> getNearingOutOfStockMedicines() {

		String val = configurationService.getConfigValue("STOCK_REORDER_THRESHOLD");

		List<NearingOutOfStockDTO> medicines = medicineRepository.getNearingOutOfStockMedicine(Integer.parseInt(val));

		System.out.println(medicines.size());

		return medicines;
	}

//	@Override
//	public List<LocationsDetailsDTO> getLocationWiseStock() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<MedicineDTO> findAllDistinctMedicines() {
		return medicineRepository.findDistinctMedicines().stream().map(p -> new MedicineDTO(p.getId(), p.getName()))
				.toList();

	}

	@Transactional
    public void reduceStock(
            Long medicineId,
            Long locationId,
            Integer requiredQuantity) {

        if (requiredQuantity == null || requiredQuantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

        List<Medicine> medicines =
                medicineRepository.findAvailableStockByExpiry(
                        medicineId,
                        locationId);

        int remainingQuantity = requiredQuantity;

        for (Medicine medicine : medicines) {

            if (remainingQuantity <= 0) {
                break;
            }

            long available = medicine.getQuantityInStock();

            int quantityToTake =
                    (int) Math.min(available, remainingQuantity);

            medicine.setQuantityInStock(
                    available - quantityToTake);

            remainingQuantity -= quantityToTake;

            medicineRepository.save(medicine);
        }

        if (remainingQuantity > 0) {

            throw new InsufficientStockException(
                    "Insufficient stock for medicineId: "
                    + medicineId
                    + ", locationId: "
                    + locationId
                    + ", requested: "
                    + requiredQuantity);
        }
    }
	@Override
	public List<MedicineDTO> findByLocationId(Long id) {

		return medicineRepository.findDistinctMedicines().stream().map(p -> new MedicineDTO(p.getId(), p.getName()))
				.toList();
	}

	@Override
	public List<LocationsDetailsDTO> getLocationWiseStock() {
		// TODO Auto-generated method stub
		return null;
	}

}
