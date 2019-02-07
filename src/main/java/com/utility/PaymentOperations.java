package com.utility;

import com.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentOperations extends ExcelService {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private Date date = new Date();
    private double rest;

    public PaymentOperations() {

    }


    public void lowerPaymentAmount(Row row, double paymentAmount) {
        double expAmo = row.getCell(9)
                .getNumericCellValue();

        row.createCell(6)
                .setCellValue(dateFormat.format(date));

        row.createCell(7)
                .setCellValue(paymentAmount);

        rest = row.getCell(5).getNumericCellValue() - paymentAmount;

        row.getCell(9)
                .setCellValue(expAmo + rest);

    }

    public void equalPaymentAmount(Row row, double paymentAmount, int installmentCount) {
        row.createCell(6)
                .setCellValue(dateFormat.format(date));

        row.createCell(7)
                .setCellValue(paymentAmount);

        row.createCell(3)
                .setCellValue(installmentCount += 1);
    }

    public void greaterPaymentAmount(Row row, double paymentAmount) {
        double expAmo = row.getCell(9)
                .getNumericCellValue();

        row.createCell(6)
                .setCellValue(dateFormat.format(date));

        row.createCell(7)
                .setCellValue(paymentAmount);

        rest = row.getCell(5).getNumericCellValue() - paymentAmount;

        row.getCell(9)
                .setCellValue(expAmo + rest);
    }
}
