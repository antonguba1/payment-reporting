package com.service;

import com.model.Installment;
import com.model.PaymentSchedule;
import com.model.PaymentScheduleInfo;
import com.model.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteSchedulesToExcel {

    private static String[] generalHeader = {"Name", "E-mail", "Actual total amount", "Expected total amount"};


    private String[] createDynamicHeader(PaymentScheduleInfo paymentScheduleInfo) {



        int j = paymentScheduleInfo.getNumberOfInstallments();
        String[] paymentHeader = new String[4 * j];
        int a = 1;
        for (int i = 0; i < j; i = i + 4) {
            paymentHeader[i] = "Due date " + Integer.toString(a);
            paymentHeader[i + 1] = "Expected amount " + Integer.toString(a);
            paymentHeader[i + 2] = "Actual date " + Integer.toString(a);
            paymentHeader[i + 3] = "Actual amount " + Integer.toString(a);
            a = a + 1;
        }
        return paymentHeader;
    }


    public void saveScheduleToExcel(User user) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("User");
        String fileName = user.getName() + "_payment_schedule.xlsx";

        addGeneralHeader(workbook, sheet);
        addInstallmentPart(workbook, sheet, user);

        for (int i = 0; i < generalHeader.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    private void addGeneralHeader(Workbook workbook, Sheet sheet) {
        Font headerUserFont = workbook.createFont();
        headerUserFont.setBold(true);
        headerUserFont.setFontHeightInPoints((short) 14);
        headerUserFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerUserCellStyle = workbook.createCellStyle();
        headerUserCellStyle.setFont(headerUserFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < generalHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(generalHeader[i]);
            cell.setCellStyle(headerUserCellStyle);
        }

    }
    private void addInstallmentPart(Workbook workbook, Sheet sheet, User user) {
        Font headerInstallmentFont = workbook.createFont();
        headerInstallmentFont.setBold(true);
        headerInstallmentFont.setFontHeightInPoints((short) 14);
        headerInstallmentFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerInstallmentCellStyle = workbook.createCellStyle();
        headerInstallmentCellStyle.setFont(headerInstallmentFont);


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
            cell.setCellStyle(headerInstallmentCellStyle);
        }

    }

}
