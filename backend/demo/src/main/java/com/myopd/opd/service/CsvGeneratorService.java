package com.myopd.opd.service;

import java.io.IOException;

import com.myopd.opd.entity.SalesOrder;

public interface CsvGeneratorService {
    byte[] generateSalesOrderCsv(SalesOrder salesOrder) throws IOException;
}
