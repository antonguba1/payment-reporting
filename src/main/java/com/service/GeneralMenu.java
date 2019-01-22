package com.service;

import com.model.User;
import com.utility.ScannerUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class GeneralMenu {

    public static void runProgram() throws IOException, InvalidFormatException {
        ScannerUtility scannerUtility = new ScannerUtility();
        int choice;

        System.out.println("Choice one from the following options:");
        System.out.println("\n1. Create payment schedule for user.");
        System.out.println("2. Add user to payment schedule.");

        choice = scannerUtility.scanInteger();

        switch (choice) {
            case 1:
                CreateScheduleService createScheduleService = new CreateScheduleService();
                User user = createScheduleService.createSchedule();
                WriteUserToExcelService writeUserToExcelService = new WriteUserToExcelService();
                writeUserToExcelService.saveUserToExcel(user);
                return;

            case 2:
                CreateScheduleService createScheduleService2 = new CreateScheduleService();
                User user2 = createScheduleService2.createSchedule();
                WriteScheduleToExcel writeScheduleToExcel = new WriteScheduleToExcel();
                writeScheduleToExcel.generateSchedule(user2);
                return;
        }
    }

}
