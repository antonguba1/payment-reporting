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


public class AddPaymentService extends PaymentOperations {

    EmailValidation emailValidation;


    public void addPayment() throws IOException, InvalidFormatException {

        AddPaymentInfo addPaymentInfo = new AddPaymentInfo();

        Files.createDirectories(Paths.get(EXCEL_PATH));

        int installmentCount;

        Path path = Paths.get(FILENAME);

        String email = addPaymentInfo.getUserMail();
        double paymentAmount = addPaymentInfo.getPaymentAmount();
        int rowNumber = addPaymentInfo.getUserRow(email);


        if (Files.exists(path)) {
            InputStream inp = new FileInputStream(FILENAME);
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet("User");

            Row row = sheet.getRow(rowNumber);

            installmentCount = (int) row.getCell(3)
                    .getNumericCellValue();

            if (paymentAmount == row.getCell(5).getNumericCellValue()) {
                equalPaymentAmount(row, paymentAmount, installmentCount);

            } else if (paymentAmount > row.getCell(5).getNumericCellValue()) {
                greaterPaymentAmount(row, paymentAmount);

            } else if (paymentAmount < row.getCell(5).getNumericCellValue()) {
                lowerPaymentAmount(row, paymentAmount);
            }

            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            workbook.write(fileOut);
            fileOut.close();

            workbook.close();

        } else {
            System.out.println("File not exist");
        }
    }

}








