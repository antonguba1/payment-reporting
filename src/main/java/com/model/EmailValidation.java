package com.model;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class EmailValidation {

    User user;

    public boolean validateEmail(String email) {

        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            System.out.println("E-mail should constains '@' and '.' . Enter your e-mail again.");
            return false;
        }
    }

    //skakać rząd > komórka
    public void existEmail() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File("Payment_schedule.xlsx"));
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        Sheet sheet = sheetIterator.next();

        Iterator<Row> rowIterator = sheet.rowIterator();

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            for (int i = 0; i < 2; i++) {

                Cell cell = cellIterator.next();
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue + "\t");

            }
        }



    public static void main(String[] args) throws IOException, InvalidFormatException {


        EmailValidation emailValidation = new EmailValidation();

        emailValidation.existEmail();

    }
}