package com.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailValidation {

    List<String> cellList;

    public boolean validateEmail(String email) {

        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            System.out.println("E-mail should constains '@' and '.' . Enter your e-mail again.");
            return false;
        }
    }

    public boolean isEmailExist(String email) throws IOException, InvalidFormatException {
        emailCollector();

        for (String element : cellList) {
            if (element.equals(email)) {
                System.out.println("This e-mail exist, enter your e-mail again.");
                return false;
            }
        }
        return true;
    }

    private List<String> emailCollector() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File("Payment_schedule.xlsx"));
        Sheet sheet = workbook.getSheet("User");

        cellList = new ArrayList<>();

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            cellList.add(sheet.getRow(i).getCell(1).getStringCellValue());
        }
        return cellList;
    }

}