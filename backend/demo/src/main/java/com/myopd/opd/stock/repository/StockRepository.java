package com.myopd.opd.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myopd.opd.entity.Medicine;
import com.myopd.opd.stock.dto.IdNameDTO;

@Repository
public interface StockRepository extends JpaRepository<Medicine, Long> {

    /* ---------- LOCATIONS ---------- */
 
    @Query(value = """
    	    SELECT DISTINCT
    	        lm.location_id AS id,
    	        lm.location_name AS name
    	    FROM medicine_master mm
    	    JOIN location_master lm ON lm.location_id = mm.location_id
    	    WHERE (:locationId IS NULL OR mm.location_id = :locationId)
    	      AND (:companyId IS NULL OR mm.company_id = :companyId)
    	      AND (:medicineName IS NULL OR mm.medicine_name = :medicineName)
    	    ORDER BY lm.location_name
    	    """, nativeQuery = true)
    	List<IdNameDTO> findLocations(
    	    @Param("locationId") Long locationId,
    	    @Param("companyId") Long companyId,
    	    @Param("medicineName") String medicineName
    	);
    

    /* ---------- MEDICINES (distinct by name, FEFO aware) ---------- */
    @Query(value = """
    SELECT DISTINCT
        mm.medicine_name AS name
    FROM medicine_master mm
    WHERE (:locationId IS NULL OR mm.location_id = :locationId)
      AND (:companyId IS NULL OR mm.company_id = :companyId)
      AND (:medicineName IS NULL OR mm.medicine_name = :medicineName)
    ORDER BY mm.medicine_name
    """, nativeQuery = true)
    
    
    List<IdNameDTO> findMedicines(
    	    @Param("locationId") Long locationId,
    	    @Param("companyId") Long companyId,
    	    @Param("medicineName") String medicineName
    	);
    /* ---------- COMPANIES ---------- */

    
    @Query(value = """
    SELECT DISTINCT
        cm.company_id AS id,
        cm.company_name AS name
    FROM medicine_master mm
    JOIN company_master cm ON cm.company_id = mm.company_id
    WHERE (:locationId IS NULL OR mm.location_id = :locationId)
      AND (:medicineName IS NULL OR mm.medicine_name = :medicineName)
      AND (:companyId IS NULL OR cm.company_id = :companyId)
    ORDER BY cm.company_name
    """, nativeQuery = true)
    
    	List<IdNameDTO> findCompanies(
    	    @Param("locationId") Long locationId,
    	    @Param("medicineName") String medicineName,
    	    @Param("companyId") Long companyId
    	);

    /* ---------- FEFO STOCK ---------- */
   
    @Query(value = """
    SELECT *
    FROM medicine_master
    WHERE location_id = :locationId
      AND medicine_name = :medicineName
      AND company_id = :companyId
    ORDER BY expiry_date DESC
    """, nativeQuery = true)
    
    
    	List<Medicine> findStockEntries(
    	    @Param("locationId") Long locationId,
    	    @Param("companyId") Long companyId,
    	    @Param("medicineName") String medicineName
    	);
}