package com.service;

import com.model.*;
import com.utility.Loger;
import com.utility.ScannerUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadUserService {

    private EmailValidation emailValidation = new EmailValidation();

    public ReadUserService() {

    }

    public User createUser() throws IOException, InvalidFormatException {
        ScannerUtility scannerUtility = new ScannerUtility();
        User user = new User();

        String name;
        String email;

        System.out.println("Enter your following data:");

        do {
            System.out.println("\nEnter your e-mail:");
            email = scannerUtility.scanString();
        } while (!emailValidation.validateEmail(email) || !emailValidation.isEmailExist(email));

        user.setEmail(email);

        System.out.println("Enter your name: ");
        name = scannerUtility.scanString();
        user.setName(name);

        Loger.printInfo("User created. " + user);
        return user;
    }


    /* start of TheBestiaki method
     */
    public void show() throws IOException, InvalidFormatException {

        ReadUserService readUserService = new ReadUserService();

        //User user = readUserService.createUser();

        Workbook workbook = WorkbookFactory.create(new File("Students.xlsx"));

        Sheet sheet = workbook.getSheetAt(0);

        List<User> users = new ArrayList<>();


        /*INSERTING PAYMENTS
        Scanner insert = new Scanner(System.in);

        double payment = insert.nextDouble();
*/


        DataFormatter dataFormatter = new DataFormatter();

        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });

        System.out.println("\n\nAll Students Data\n");


        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            User user = new User();
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            PaymentScheduleInfo paymentScheduleInfo = new PaymentScheduleInfo();
            Row row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (j == 0) {
                    user.setName(cell.getStringCellValue());
                }
                if (j == 1) {
                    user.setEmail(cell.getStringCellValue());
                }
                if (j == 2) {
                    paymentSchedule.setActualTotalAmount(cell.getNumericCellValue());
                }
                if (j == 3) {
                    paymentSchedule.setExpectedTotalAmount(cell.getNumericCellValue());
                }
                if (j == 4) {
                    paymentScheduleInfo.setNumberOfInstallments((int) cell.getNumericCellValue());
                }
                if (j == 5) {
                    paymentScheduleInfo.setFirstDueDate(cell.getDateCellValue());
                }
                if (j == 6) {
                    paymentScheduleInfo.setInstallmentAmount(cell.getNumericCellValue());
                }
            }
            int k = 5;
            while (k < 5 + 3 * row.getCell(4).getNumericCellValue()) {
                Installment installment = new Installment();
                installment.setDueDate(row.getCell(k).getDateCellValue());
                installment.setExpectedAmount(row.getCell(k + 1).getNumericCellValue());
                installment.setActualDate(row.getCell(k + 2).getDateCellValue());
                installment.setActualAmount(row.getCell(k + 3).getNumericCellValue());
                k += 4;
                paymentSchedule.getInstallmentList().add(installment);
            }

            paymentSchedule.setPaymentScheduleInfo(paymentScheduleInfo);
            user.setPaymentSchedule(paymentSchedule);
            users.add(user);

        }
        for (User user : users) {
            System.out.println("\nName : " + user.getName() + "\nEmail : " + user.getEmail() +
                    "\n\nPayment Schedule : " + "\nActual Total Amount : " + user.getPaymentSchedule().getActualTotalAmount() + "\nExpected Total Amount : " + user.getPaymentSchedule().getExpectedTotalAmount() + "\n\nInstallment List : \n" + user.getPaymentSchedule().getInstallmentList().get(0) + "\n" + user.getPaymentSchedule().getInstallmentList().get(1) + "\n" + user.getPaymentSchedule().getInstallmentList().get(2) +
                    "\n\nPayment Schedule Info : " + "\nFirst Due Date : " + user.getPaymentSchedule().getPaymentScheduleInfo().getFirstDueDate() + "\nInstallment Amount : " + user.getPaymentSchedule().getPaymentScheduleInfo().getInstallmentAmount() + "\nNumber Of Installments : " + user.getPaymentSchedule().getPaymentScheduleInfo().getNumberOfInstallments());
        }

        workbook.close();
    }

}
