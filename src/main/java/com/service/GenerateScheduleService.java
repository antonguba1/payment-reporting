package com.service;

import com.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
;
import java.io.*;


public class GenerateScheduleService {

    private static String[] generalHeader = {"Name", "E-mail", "Actual total amount", "Expected total amount"};


    //Creating many users in one schedule.

    public void generateSchedule(User user) throws IOException, InvalidFormatException {

        Sheet sheet;
        try {
            Workbook workbook = WorkbookFactory.create(new File("Payment_schedule.xlsx"));
        } catch (FileNotFoundException e) {
            Workbook workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("User");
            String fileName = "Payment_schedule.xlsx";


            addGeneralHeader(workbook, sheet);
            addInstallmentHeader(workbook, sheet, user);
            //addUserData(workbook, sheet, user);

            for (int i = 0; i < generalHeader.length; i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();
        }

        InputStream inp = new FileInputStream("Payment_schedule.xlsx");

        Workbook workbook = WorkbookFactory.create(inp);
        sheet = workbook.getSheet("User");
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(0);

        addUserData(workbook, sheet, user);

// Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("Payment_schedule.xlsx");
        workbook.write(fileOut);
        fileOut.close();
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

    private CellStyle headerSetup(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        return headerCellStyle;
    }

    private void addUserData(Workbook workbook, Sheet sheet, User user) {
       headerSetup(workbook);
       Row userRow = sheet.createRow(1);

       userRow.createCell(0)
               .setCellValue(user.getName());
       userRow.createCell(1)
               .setCellValue(user.getEmail());
    }

    private boolean checkIsRowEmpty(Row row) {
        if (row == null) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellTypeEnum() != CellType.BLANK && StringUtils.isNotBlank(cell.toString())) {
                return false;
            }
        }
        return true;
     }

}

