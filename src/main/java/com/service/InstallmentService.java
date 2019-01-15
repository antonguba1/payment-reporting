package com.service;

import com.model.Installment;
import com.model.PaymentScheduleInfo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class InstallmentService {




    public List<Installment> generateInstallments(PaymentScheduleInfo paymentScheduleInfo) {

        List listOfInstallments = new ArrayList();


        Date firstDueDate = paymentScheduleInfo.getFirstDueDate();
        int numberOfInstallments = paymentScheduleInfo.getNumberOfInstallments();
        double installmentAmount = paymentScheduleInfo.getInstallmentAmount();

        //do zakodowania

        return listOfInstallments;
    }

}
