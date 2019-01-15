package com.service;

import com.model.Installment;
import com.model.PaymentScheduleInfo;
import com.model.User;

import java.util.List;


public class CreateScheduleService {

    private ReadUserService readUserService = new ReadUserService();
    private ReadScheduleService readScheduleService = new ReadScheduleService();
    private InstallmentService installmentService = new InstallmentService();

    public User createSchedule() {

        User user = readUserService.createUser();
        PaymentScheduleInfo paymentScheduleInfo = readScheduleService.createPaymentScheduleInfo();
        List<Installment> listOfInstallments = installmentService.generateInstallments(paymentScheduleInfo);


        return user;
    }


}