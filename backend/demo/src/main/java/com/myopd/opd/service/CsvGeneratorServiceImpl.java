package com.myopd.opd.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import com.myopd.opd.entity.OrderItem;
import com.myopd.opd.entity.SalesOrder;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

@Service
public class CsvGeneratorServiceImpl implements CsvGeneratorService {

	@Override
	public byte[] generateSalesOrderCsv(SalesOrder salesOrder) throws IOException {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
				CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {

			// 1️⃣ Add Sales Order Details at the Top
			csvPrinter.printRecord("First Name", salesOrder.getFirstName());
			csvPrinter.printRecord("Last Name", salesOrder.getLastName());
			csvPrinter.printRecord("Email", salesOrder.getEmail().isEmpty() ? "N/A" : salesOrder.getEmail());
			csvPrinter.printRecord("Date of Purchase", salesOrder.getDateOfPurchase());
			csvPrinter.println(); // Blank line for spacing

			// 2️⃣ Add Table Headers
			csvPrinter.printRecord("Medicine", "Type", "Company", "Location", "Quantity", "Total Price");

			// 3️⃣ Add Table Data
			for (OrderItem item : salesOrder.getOrderItems()) {
				csvPrinter.printRecord(item.getSelectedMedicine(), item.getSelectedMedicineType(),
						item.getSelectedCompany(), item.getSelectedLocation(), item.getQuantity(),
						item.getTotalPrice());
			}

			csvPrinter.flush();
			return outputStream.toByteArray();
		}
	}

}
