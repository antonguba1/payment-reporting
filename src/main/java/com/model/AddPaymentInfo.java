package com.model;

import com.utility.ScannerUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.service.ExcelService.EXCEL_PATH;

public class AddPaymentInfo {

    private EmailValidation emailValidation = new EmailValidation();


    public AddPaymentInfo() {

    }

    public int getUserRow(String email) throws IOException, InvalidFormatException {

        Row row;
        int i = 1;
        Path path = Paths.get(EXCEL_PATH + "/Payment_schedule.xlsx");

        InputStream inp = new FileInputStream(String.valueOf(path));
        Workbook workbook = WorkbookFactory.create(inp);
        Sheet sheet = workbook.getSheet("User");


        for (i = 1; i <= sheet.getLastRowNum(); i++) {
            if (email.contains(sheet.getRow(i).getCell(1).getStringCellValue())) {
                break;
            }
            //TODO what if not found email (else).
        }


        return i;
    }

    public String getUserMail() throws IOException, InvalidFormatException {

        String email;
        ScannerUtility scannerUtility = new ScannerUtility();

        do {
            System.out.println("Write user e-mail:");
            email = scannerUtility.scanString();
        } while (!emailValidation.validateEmail(email) || !emailValidation.isEmailExist2(email));

        return email;
    }

    public double getPaymentAmount() {

        double paymentAmount;
        ScannerUtility scannerUtility = new ScannerUtility();

        System.out.println("Write payment amount:");
        paymentAmount = scannerUtility.scanDouble();

        return paymentAmount;
    }
}
