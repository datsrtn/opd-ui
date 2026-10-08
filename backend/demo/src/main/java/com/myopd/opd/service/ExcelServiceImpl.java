package com.myopd.opd.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.myopd.opd.dto.sale.SalesForExcelSheetDTO;
@Service
public class ExcelServiceImpl implements ExcelService {

    private static final String SHEET_NAME = "SELL SHEET";

    private final String excelFilePath="C:\\Programming\\excelsheet\\SELL.xlsx";

//    public ExcelServiceImpl( String excelFilePath) {
//
//        this.excelFilePath = excelFilePath;
//    }

    @Override
    public void appendSalesToExcel(List<SalesForExcelSheetDTO> sales) throws IOException {

        try (FileInputStream inputStream =
                     new FileInputStream(excelFilePath);
             Workbook workbook =
                     new XSSFWorkbook(inputStream)) {

            // Debug: print all sheet names
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println(
                    "Sheet " + i + " = ["
                    + workbook.getSheetName(i)
                    + "]"
                );
            }

            Sheet sheet = workbook.getSheet(SHEET_NAME);

            if (sheet == null) {
                throw new IllegalStateException(
                    "Sheet '" + SHEET_NAME
                    + "' not found in file: "
                    + excelFilePath
                );
            }

            int nextRowNumber = getNextEmptyRow(sheet);

            System.out.println(
                "Starting Excel row = " + nextRowNumber
            );

            for (SalesForExcelSheetDTO sale : sales) {

                Row row = sheet.createRow(nextRowNumber++);

                // DATE
                row.createCell(0)
                   .setCellValue(sale.getPurchaseDate());

                // PRODUCT
                row.createCell(1)
                   .setCellValue(sale.getMedicineName());

                // QUANTITY
                row.createCell(2)
                   .setCellValue(sale.getTotalQuantity());

                // TOTAL PRICE
                row.createCell(3)
                   .setCellValue(
                       sale.getTotalSales().doubleValue()
                   );

                // NAME
                row.createCell(4)
                   .setCellValue(sale.getFirstName());
            }

            try (FileOutputStream outputStream =
                         new FileOutputStream(excelFilePath)) {

                workbook.write(outputStream);
            }
        }
    }

    private int getNextEmptyRow(Sheet sheet) {

        int lastRow = sheet.getLastRowNum();

        for (int i = 0; i <= lastRow; i++) {

            Row row = sheet.getRow(i);

            if (row == null || isRowEmpty(row)) {
                return i;
            }
        }

        return lastRow + 1;
    }

    private boolean isRowEmpty(Row row) {

        if (row.getLastCellNum() <= 0) {
            return true;
        }

        for (int i = 0; i < row.getLastCellNum(); i++) {

            Cell cell = row.getCell(i);

            if (cell != null &&
                cell.getCellType() != CellType.BLANK) {

                return false;
            }
        }

        return true;
    }
}