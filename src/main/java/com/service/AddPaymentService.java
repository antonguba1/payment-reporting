package com.service;

import com.utility.ScannerUtility;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddPaymentService extends ExcelService {


    public void addPayment() throws IOException, InvalidFormatException {

        Files.createDirectories(Paths.get(EXCEL_PATH));

        Row row;
        Sheet sheet;
        String email;
        int rowNumber;
        int installmentCount;
        double paymentAmount;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        Path path = Paths.get(FILENAME);

        email = getUserMail();
        paymentAmount = getPaymentAmount();
        rowNumber = getUserRow(email);


        if (Files.exists(path)) {
            InputStream inp = new FileInputStream(FILENAME);
            Workbook workbook = WorkbookFactory.create(inp);
            sheet = workbook.getSheet("User");

            row = sheet.getRow(rowNumber);

            installmentCount = (int) row.getCell(3)
                    .getNumericCellValue();

            if (paymentAmount == row.getCell(5).getNumericCellValue()) {

                row.createCell(6)
                        .setCellValue(dateFormat.format(date));

                row.createCell(7)
                        .setCellValue(paymentAmount);

                row.createCell(3)
                        .setCellValue(installmentCount += 1);


            } else if (paymentAmount > row.getCell(5).getNumericCellValue()) {
                double rest;
                double expAmo = row.getCell(9)
                        .getNumericCellValue();

                row.createCell(6)
                        .setCellValue(dateFormat.format(date));

                row.createCell(7)
                        .setCellValue(paymentAmount);

                rest = paymentAmount - row.getCell(5).getNumericCellValue();

                row.getCell(9)
                        .setCellValue(expAmo - rest);


            } else if (paymentAmount < row.getCell(5).getNumericCellValue()) {

                double rest;
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

            System.out.println(row.getCell(7).getNumericCellValue());


            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            workbook.write(fileOut);
            fileOut.close();

            workbook.close();
        } else {
            System.out.println("File not exist");
        }
    }


    private int getUserRow(String email) throws IOException, InvalidFormatException {

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

        }


        return i;
    }

    private String getUserMail() {

        String email;
        ScannerUtility scannerUtility = new ScannerUtility();

        System.out.println("Write user e-mail:");
        email = scannerUtility.scanString();

        return email;
    }

    private double getPaymentAmount() {

        double paymentAmount;
        ScannerUtility scannerUtility = new ScannerUtility();

        System.out.println("Write payment amount:");
        paymentAmount = scannerUtility.scanDouble();

        return paymentAmount;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {

        AddPaymentService test = new AddPaymentService();


        test.addPayment();
        //System.out.println(test.getUserRow("lo@."));
    }
}







