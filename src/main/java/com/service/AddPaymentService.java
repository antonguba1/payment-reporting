package com.service;

import com.model.EmailValidation;
import com.model.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddPaymentService {

    EmailValidation emailValidation = new EmailValidation();

    public void addPayment(User user) {


    }


    private Row getUserRow(String email) throws IOException, InvalidFormatException {

        Row row;
        int i = 1;
        Path path = Paths.get(ExcelService.EXCEL_PATH + "/Payment_schedule.xlsx");

            InputStream inp = new FileInputStream(String.valueOf(path));
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet("User");

            for (i = 1; i <= sheet.getLastRowNum(); i++) {
                if (email.contains(sheet.getRow(i).getCell(1).getStringCellValue())) {
                    break;
                }

            }
            row = sheet.getRow(i);

        return row;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {

        AddPaymentService test = new AddPaymentService();

        System.out.println(test.getUserRow("lo@.").getRowNum());
    }
}
