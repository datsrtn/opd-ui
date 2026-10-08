package com.myopd.opd.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;
import com.myopd.opd.entity.SalesOrder;
@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

	List<SalesOrder> findByDateOfPurchaseBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	@Query("SELECT so FROM SalesOrder so JOIN FETCH so.orderItems WHERE DATE(so.dateOfPurchase) = :date")
	List<SalesOrder> findOrdersByDate(@Param("date") LocalDate date);
	
	
	@Query(value = """
		      SELECT
        so.first_name AS "firstName",
        oi.selected_medicine AS "medicineName",
        oi.selected_company AS "companyName",
        TO_CHAR(so.date_of_purchase, 'YYYYMMDD') AS "purchaseDate",
        oi.quantity AS "totalQuantity",
        oi.total_price AS "totalSales"
    FROM sales_order so
    INNER JOIN order_item oi
        ON so.id = oi.sales_order_id
    WHERE so.date_of_purchase >= CAST(:fromDate AS TIMESTAMP)
      AND so.date_of_purchase < (
          CAST(:toDate AS TIMESTAMP) + INTERVAL '1 day'
      )
    ORDER BY
        so.date_of_purchase,
        so.id,
        oi.id
		    """, nativeQuery = true)
		List<SalesForExcelSheetDTO> getMedicineSalesReport(
		        @Param("fromDate") LocalDate fromDate,
		        @Param("toDate") LocalDate toDate);
}