package com.service;

import com.model.Installment;
import com.model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelService {

    private static String[] userColumns = {"Name", "E-mail", "Actual total amount", "Expected total amount"};
    private static String[] installmentColumns = {"Due date", "", "Actual amount", "Expected amount"};

    public void saveUserToExcel(User user) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("User");
        String fileName = user.getName() + "_payment_schedule.xlsx";

        addUserPart(workbook, sheet, user);
        addInstallmentPart(workbook, sheet, user.getPaymentSchedule().getInstallmentList());

        for(int i = 0; i < userColumns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    private void addUserPart(Workbook workbook, Sheet sheet, User user) {
        Font headerUserFont = workbook.createFont();
        headerUserFont.setBold(true);
        headerUserFont.setFontHeightInPoints((short) 14);
        headerUserFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerUserCellStyle = workbook.createCellStyle();
        headerUserCellStyle.setFont(headerUserFont);

        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < userColumns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(userColumns[i]);
            cell.setCellStyle(headerUserCellStyle);
        }

        Row row = sheet.createRow(1);

        row.createCell(0)
                .setCellValue(user.getName());

        row.createCell(1)
                .setCellValue(user.getEmail());

        row.createCell(2)
                .setCellValue(user.getPaymentSchedule().getActualTotalAmount());

        row.createCell(3)
                .setCellValue(user.getPaymentSchedule().getExpectedTotalAmount());
    }

    private void addInstallmentPart(Workbook workbook, Sheet sheet, List<Installment> installmentList) {
        Font headerInstallmentFont = workbook.createFont();
        headerInstallmentFont.setBold(true);
        headerInstallmentFont.setFontHeightInPoints((short) 14);
        headerInstallmentFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerInstallmentCellStyle = workbook.createCellStyle();
        headerInstallmentCellStyle.setFont(headerInstallmentFont);

        Row headerRow = sheet.createRow(4);

        for(int i = 0; i < installmentColumns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(installmentColumns[i]);
            cell.setCellStyle(headerInstallmentCellStyle);
        }

        int rowNum = 5;

        for (Installment installment : installmentList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0)
                    .setCellValue(installment.getDueDate().toString());
            row.createCell(2)
                    .setCellValue(installment.getActualAmount());
            row.createCell(3)
                    .setCellValue(installment.getExpectedAmount());

        }
    }

}
