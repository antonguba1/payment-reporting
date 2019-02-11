package com.service;

import com.model.AddPaymentInfo;

import com.model.EmailValidation;
import com.utility.PaymentOperations;
import com.model.EmailValidation.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.model.GeneralHeader.*;
import static com.model.InstallmentHeader.*;

public class AddPaymentService extends PaymentOperations {




    public void addPayment() throws IOException, InvalidFormatException {

        AddPaymentInfo addPaymentInfo = new AddPaymentInfo();

        Files.createDirectories(Paths.get(EXCEL_PATH));

        int installmentCount;

        Path path = Paths.get(FILENAME);

        String email = addPaymentInfo.getUserMail();
        int rowNumber = addPaymentInfo.getUserRow(email);
        double paymentAmount = addPaymentInfo.getPaymentAmount();

        if (Files.exists(path)) {
            InputStream inp = new FileInputStream(FILENAME);
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet("User");

            Row row = sheet.getRow(rowNumber);

            installmentCount = (int) row.getCell(ACTUAL_INSTALLMENT_NUMBER.ordinal())
                    .getNumericCellValue();

            if (paymentAmount == row.getCell(EXPECTED_AMOUNT.ordinal()).getNumericCellValue()) {
                equalPaymentAmount(sheet, rowNumber, paymentAmount, installmentCount);

            } else if (paymentAmount > row.getCell(EXPECTED_AMOUNT.ordinal()).getNumericCellValue()) {
                greaterPaymentAmount(sheet, rowNumber, paymentAmount);

            } else if (paymentAmount < row.getCell(EXPECTED_AMOUNT.ordinal()).getNumericCellValue()) {
                lowerPaymentAmount(sheet, rowNumber, paymentAmount);
            }

            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            workbook.write(fileOut);
            fileOut.close();

            workbook.close();

        } else {
            System.out.println("File not exist.");
        }
    }

}








