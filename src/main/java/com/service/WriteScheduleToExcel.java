package com.service;

import com.model.Installment;
import com.model.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class WriteScheduleToExcel extends ExcelService {

    private static final String fileName = "Payment_schedule.xlsx";
    private static final String[] generalHeader = {"Name", "E-mail", "Actual total amount", "Expected total amount"};

    //Creating many users in one schedule.
    public void generateSchedule(User user) throws IOException, InvalidFormatException {
        Sheet sheet;

        //Check path before running the program -> ExcelService class.
        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            InputStream inp = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(inp);

            sheet = workbook.getSheet("User");

            addStaff(workbook, sheet, user);

            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();

        } else {
            Workbook workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("User");

            addStaff(workbook, sheet, user);

            for (int i = 0; i < generalHeader.length; i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();
        }
    }

    private void addGeneralHeader(Workbook workbook, Sheet sheet) {
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < generalHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(generalHeader[i]);
            cell.setCellStyle(headerSetup(workbook));
        }
    }

    private void addInstallmentHeader(Workbook workbook, Sheet sheet, User user) {

        int j = user.getPaymentSchedule().getInstallmentList().size();
        String[] paymentHeader = new String[4 * j];
        int a = 1;

        for (int i = 0; i < paymentHeader.length; i += 4) {
            paymentHeader[i] = "Due date " + Integer.toString(a);
            paymentHeader[i + 1] = "Expected amount " + Integer.toString(a);
            paymentHeader[i + 2] = "Actual date " + Integer.toString(a);
            paymentHeader[i + 3] = "Actual amount " + Integer.toString(a);
            a += 1;
        }

        Row headerRow = sheet.getRow(0);

        for (int i = 0; i < 4 * j; i++) {
            Cell cell = headerRow.createCell(i + 4);
            cell.setCellValue(paymentHeader[i]);
            cell.setCellStyle(headerSetup(workbook));
            sheet.autoSizeColumn(i);
        }
    }

    private void addUserData(Workbook workbook, Sheet sheet, User user) {
        headerSetup(workbook);

        Row row = sheet.createRow(sheet.getLastRowNum() + 1);

        row.createCell(0)
                .setCellValue(user.getName());

        row.createCell(1)
                .setCellValue(user.getEmail());

        row.createCell(2)
                .setCellValue(user.getPaymentSchedule().getActualTotalAmount());

        row.createCell(3)
                .setCellValue(user.getPaymentSchedule().getExpectedTotalAmount());

    }

    private void addInstallmentData(Workbook workbook, Sheet sheet, List<Installment> installmentList) {
        headerSetup(workbook);

        Row row = sheet.getRow((sheet.getLastRowNum()));
        for (int i = 0; i < installmentList.size(); i++) {
            int a = 4;
            for (Installment installment : installmentList) {
                row.createCell(a)
                        .setCellValue(installment.getDueDate().toString());

                row.createCell(a + 1)
                        .setCellValue(installment.getExpectedAmount());

                row.createCell(a + 2)
                        .setCellValue("here actual date");

                row.createCell(a + 3)
                        .setCellValue(installment.getActualAmount());
                a += 4;
            }
        }
    }

    private void addStaff(Workbook workbook, Sheet sheet, User user) {
        addGeneralHeader(workbook, sheet);
        addInstallmentHeader(workbook, sheet, user);
        addUserData(workbook, sheet, user);
        addInstallmentData(workbook, sheet, user.getPaymentSchedule().getInstallmentList());
    }
}

