package com.myopd.opd.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myopd.opd.dto.medicine.InsufficientStockDTO;
import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;
import com.myopd.opd.dto.sale.SalesOrderDTO;
import com.myopd.opd.entity.Location;
import com.myopd.opd.entity.Medicine;
import com.myopd.opd.entity.OrderItem;
import com.myopd.opd.entity.SalesOrder;
import com.myopd.opd.exception.InsufficientStockException;
import com.myopd.opd.repository.LocationRepository;
import com.myopd.opd.repository.MedicineRepository;
import com.myopd.opd.repository.SalesOrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService {

    private final MedicineServiceImpl medicineServiceImpl;

	private final LocationRepository locationRepository;

	private final SalesOrderRepository salesOrderRepository;
	private final MedicineRepository medicineRepository;

	public SalesOrderServiceImpl(SalesOrderRepository salesOrderRepository, MedicineRepository medicineRepository,
			LocationRepository locationRepository, MedicineServiceImpl medicineServiceImpl) {

		System.out.println("=================================");
		System.out.println("CONSTRUCTOR");
		System.out.println("Service instance = " + this);
		System.out.println("Repository = " + salesOrderRepository);
		System.out.println("=================================");

		this.salesOrderRepository = salesOrderRepository;
		this.medicineRepository = medicineRepository;
		this.locationRepository = locationRepository;
		this.medicineServiceImpl = medicineServiceImpl;
	}

	@Override
	public SalesOrder saveOrder(SalesOrderDTO salesOrderDTO) {

		HashMap<Long, Integer> medicineIdMap = new HashMap<>();

		HashMap<String, String> errorMessageMap = new HashMap<>();

		salesOrderDTO.getOrderItems().forEach(item -> {
			System.out.println(salesOrderDTO.getOrderItems());
			medicineIdMap.put(item.getMedicineId(), item.getQuantity());
			errorMessageMap.put(item.getSelectedMedicine(), item.getSelectedLocation());
		});

		List<InsufficientStockDTO> insufficientStockList = new ArrayList<>();

		// 1. Reduce stock
		for (Entry<Long, Integer> entry : medicineIdMap.entrySet()) {
//
			//medicineServiceImpl.reduceStock(entry.getKey(), medicineIdMap.get(entry.getKey()));
			int updatedRows = medicineRepository.reduceStock(entry.getKey(), medicineIdMap.get(entry.getKey()));

			// locationRepository.

			// 2. Check whether stock was available
			if (updatedRows == 0) {

				Long medicineId = entry.getKey();

				Integer id = medicineId.intValue();

				Optional<Medicine> medicine = medicineRepository.findById(id);
				System.out.println(medicine.toString());

				Optional<Location> location = locationRepository.findById(medicine.get().getLocationId());

//				  medicineRepository.findById(id).ifPresent(medicine -> {
//					  String medicineName = medicine.getMedicineName();
//					  InsufficientStockDTO insufficientStockDTO = new InsufficientStockDTO(
//							  medicineId,
//							  medicineName,
//							  medicineName, medicineIdMap.get(entry.getKey())
//					  );
				// insufficientStockList.add(insufficientStockDTO);
				// });

				System.out.println("printint error message map");
				System.out.println(errorMessageMap);
				for (Entry<String, String> errorEntry : errorMessageMap.entrySet()) {
					System.out.println("Insufficient stock for medicine : " + errorEntry.getKey()  + "  LOCATION : "
							+ errorEntry.getValue());
					throw new InsufficientStockException("Insufficient stock for medicine : "
							+ errorEntry.getKey()  + " LOCATION : " + errorEntry.getValue());
				
			}

		}
	}

	SalesOrder salesOrder = new SalesOrder();

	salesOrder.setFirstName(salesOrderDTO.getFirstName());salesOrder.setLastName(salesOrderDTO.getLastName());salesOrder.setEmail(salesOrderDTO.getEmail());salesOrder.setDateOfPurchase(salesOrderDTO.getDateOfPurchase());

	List<OrderItem> orderItems = salesOrderDTO.getOrderItems().stream().map(dto -> {
		OrderItem item = new OrderItem();
		item.setSelectedMedicine(dto.getSelectedMedicine());
		item.setSelectedMedicineType(dto.getSelectedMedicineType());
		item.setSelectedCompany(dto.getSelectedCompany());
		item.setSelectedLocation(dto.getSelectedLocation());
		item.setQuantity(dto.getQuantity());
		item.setTotalPrice(dto.getTotalPrice());
		item.setSalesOrder(salesOrder);
		return item;
	}).collect(Collectors.toList());

	salesOrder.setOrderItems(orderItems);

	double totalAmountForCurrentOrder = orderItems.stream().mapToDouble(OrderItem::getTotalPrice)
			.sum();salesOrder.setTotalDue(totalAmountForCurrentOrder);salesOrder.setAmountPaid(totalAmountForCurrentOrder);

	SalesOrder retVal = salesOrderRepository.save(salesOrder);

// 
//      // 2. Check whether stock was available
//      if (updatedRows == 0) {
//
//          throw new InsufficientStockException(
//                  "Insufficient stock for "
//                  + dto.getSelectedMedicine()
//          );
//      }

	return retVal;

	//
	}

	@Override
    public List<SalesOrder> getOrdersByDate(LocalDate date) {

        return salesOrderRepository.findByDateOfPurchaseBetween(
                date.atStartOfDay(),
                date.plusDays(1).atStartOfDay()
        );
    }

	@Override
    public List<SalesOrder> getAllOrders() {
        return salesOrderRepository.findAll();
    }

	@Override
	public Optional<SalesOrder> getSalesOrderById(Long id) {
		return salesOrderRepository.findById(id);
	}

	@Override
	public List<SalesForExcelSheetDTO> getMedicineSalesReport(LocalDate fromDate, LocalDate toDate) {

		System.out.println("=================================");
		System.out.println("Inside getMedicineSalesReport()");
		System.out.println("Service instance = " + this);
		System.out.println("Repository = " + salesOrderRepository);
		System.out.println("fromDate = " + fromDate);
		System.out.println("toDate = " + toDate);
		System.out.println("=================================");

		if (fromDate == null) {
			fromDate = LocalDate.now();
		}

		if (toDate == null) {
			toDate = LocalDate.now();
		}

		return salesOrderRepository.getMedicineSalesReport(fromDate, toDate);
	}
}
