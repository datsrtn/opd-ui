package com.myopd.opd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.myopd.opd.dto.medicine.ExpiringMedicinesDTO;
import com.myopd.opd.dto.medicine.MedicineDTO;
import com.myopd.opd.dto.medicine.NearingOutOfStockDTO;
import com.myopd.opd.dto.medicine.PurchaseOrderMedicineDTO;
import com.myopd.opd.entity.Medicine;

import jakarta.persistence.LockModeType;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	@Query("SELECT new com.myopd.opd.dto.medicine.NearingOutOfStockDTO( m.medicineName,c.companyName AS companyName, m.quantityInStock, m.batch,	l.location AS location ) "
			+ "FROM  Medicine m LEFT JOIN Company c ON m.companyId = c.companyId LEFT JOIN Location l ON m.locationId = l.locationId"
			+ " WHERE m.quantityInStock< :limit")
	List<NearingOutOfStockDTO> getNearingOutOfStockMedicine(@Param("limit") int lowerLimitForMedicines);

	@Query("SELECT new com.myopd.opd.dto.medicine.ExpiringMedicinesDTO (m.medicineName, c.companyName AS companyName , m.expiryDate) "
			+ " FROM Medicine m LEFT JOIN Company c ON m.companyId = c.companyId "
			+ "WHERE m.expiryDate < (CURRENT_DATE ) ")
	List<ExpiringMedicinesDTO> getAllExpiringMedicines();

	// PurchaseOrderMedicineDTO(String medicineType, String companyName, Date
	// expiryDate, float pricePerUnu.unitit, String locationName, String batch) {

	@Query("SELECT new com.myopd.opd.dto.medicine.PurchaseOrderMedicineDTO (m.medicineId, m.medicineName, c.companyName AS companyName , m.expiryDate, m.pricePerUnit,	l.location AS location, m.batch, m.quantityInStock) "
			+ " FROM Medicine m   LEFT JOIN Company c ON m.companyId = c.companyId  LEFT JOIN Location l ON m.locationId = l.locationId ")
	List<PurchaseOrderMedicineDTO> getAllMedicinesforPurchaseOrder();

	@Query(value = """
			    SELECT DISTINCT ON (medicine_name)
			        medicine_id AS id,
			        medicine_name AS name
			    FROM medicine_master
			    ORDER BY medicine_name, medicine_id
			""", nativeQuery = true)
	List<MedicineIdNameProjection> findDistinctMedicines();


	
	@Modifying
	@Query("""
	    UPDATE Medicine m
	    SET m.quantityInStock = m.quantityInStock - :quantity
	    WHERE m.medicineId = :medicineId
	      AND m.quantityInStock >= :quantity
	    """)
	int reduceStock(
	        @Param("medicineId") Long medicineId,
	        @Param("quantity") Integer quantity);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("""
	        SELECT m
	        FROM Medicine m
	        WHERE m.medicineId = :medicineId
	          AND m.locationId = :locationId
	          AND m.quantityInStock > 0
	        ORDER BY m.expiryDate ASC
	        """)
	    List<Medicine> findAvailableStockByExpiry(
	            @Param("medicineId") Long medicineId,
	            @Param("locationId") Long locationId);
	
}

