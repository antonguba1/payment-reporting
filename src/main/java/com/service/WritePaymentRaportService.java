package com.service;

import com.model.ExcelService;
import com.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WritePaymentRaportService extends ExcelService {

    private static final String[] generalHeader = {"Name", "E-mail", "Amount to pay"};


    public void generateRaport() throws IOException {

        Files.createDirectories(Paths.get(excelPath));

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Raport");
        String fileName = excelPath + "/" + "_payment_raport.xlsx";

        addGeneralHeader(workbook, sheet);
        addDatas(sheet, null);


        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }

    private void addGeneralHeader(Workbook workbook, Sheet sheet) {
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < generalHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(generalHeader[i]);
            cell.setCellStyle(headerSetup(workbook));
        }
    }

    private void addDatas(Sheet sheet, List<User> userList) {

        for (int i = 1; i <= userList.size(); i++) {
            Row row = sheet.createRow(i);

            for (User user : userList) {

                row.createCell(0)
                        .setCellValue(user.getName());

                row.createCell(1)
                        .setCellValue(user.getEmail());

                row.createCell(2)
                        .setCellValue(user.getPaymentSchedule().getArrearOfPayment());

            }
        }
    }
}
