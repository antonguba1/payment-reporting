package com.utility;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {

    private static String[] columns = { "Name","Email address", "Payments"};


    public static void main(String[] args) throws IOException,
            InvalidFormatException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PaymentSchedule");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
/*
        // Create Other rows and cells with contacts data
        int rowNum = 1;

        for (Contact contact : contacts) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(contact.firstName);
            row.createCell(1).setCellValue(contact.lastName);
            row.createCell(2).setCellValue(contact.email);
            row.createCell(3).setCellValue(contact.dateOfBirth);
        }
*/


        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("contacts.xlsx");
        workbook.write(fileOut);
        fileOut.close();
    }

}




