package com.utility;

import com.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.model.GeneralHeader.*;
import static com.model.InstallmentHeader.*;


public class PaymentOperations extends ExcelService {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private Date date = new Date();
    private double rest;

    public PaymentOperations() {

    }


    public void lowerPaymentAmount(Row row, double paymentAmount) {
        double expectedAmount = row.getCell(9)
                .getNumericCellValue();

        row.createCell(ACTUAL_DATE.ordinal())
                .setCellValue(dateFormat.format(date));

        row.createCell(ACTUAL_AMOUNT.ordinal())
                .setCellValue(paymentAmount);

        //rest = row.getCell(EXPECTED_AMOUNT.ordinal()).getNumericCellValue() - paymentAmount;
        rest = row.getCell(5).getNumericCellValue() - paymentAmount;


        row.getCell(9)
                .setCellValue(expectedAmount + rest);

    }

    public void equalPaymentAmount(Row row, double paymentAmount, int installmentCount) {
        row.createCell(ACTUAL_DATE.ordinal())
                .setCellValue(dateFormat.format(date));

        row.createCell(ACTUAL_AMOUNT.ordinal())
                .setCellValue(paymentAmount);

        row.createCell(ACTUAL_INSTALLMENT_NUMBER.ordinal())
                .setCellValue(installmentCount += 1);
    }

    public void greaterPaymentAmount(Row row, double paymentAmount) {
        double expectedAmount = row.getCell(9)
                .getNumericCellValue();

        row.createCell(ACTUAL_DATE.ordinal())
                .setCellValue(dateFormat.format(date));

        row.createCell(ACTUAL_AMOUNT.ordinal())
                .setCellValue(paymentAmount);

        rest = row.getCell(5).getNumericCellValue() - paymentAmount;

        row.getCell(9)
                .setCellValue(expectedAmount + rest);
    }
}
