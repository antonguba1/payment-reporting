package com.service;

import com.model.*;
import com.utility.ScannerUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;


public class CreateScheduleService {

    private ReadUserService readUserService = new ReadUserService();
    private ReadScheduleService readScheduleService = new ReadScheduleService();
    private InstallmentService installmentService = new InstallmentService();

    public User createSchedule() throws IOException, InvalidFormatException {

        User user = readUserService.createUser();
        PaymentScheduleInfo paymentScheduleInfo = readScheduleService.createPaymentScheduleInfo();
        List<Installment> listOfInstallments = installmentService.generateInstallments(paymentScheduleInfo);

        PaymentSchedule paymentSchedule = new PaymentSchedule(paymentScheduleInfo, listOfInstallments);
        user.setPaymentSchedule(paymentSchedule);
        user.printInstallments();

        return user;
    }
}