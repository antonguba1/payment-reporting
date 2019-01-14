package com.company.service;



import com.company.model.PaymentScheduleInfo;

import java.util.Scanner;

import static com.company.utility.Loger.printInfo;

public class ReadScheduleService {


    protected PaymentScheduleInfo getDatasToInstallments() {


        PaymentScheduleInfo paymentScheduleInfo = new PaymentScheduleInfo();

        Scanner scNumbInst = new Scanner(System.in);
        Scanner scInstAmo = new Scanner(System.in);
        Scanner scFirstDate = new Scanner(System.in);

        printInfo("Number of installments: ");
        paymentScheduleInfo.setNumberOfInstallments(scNumbInst.nextInt());

        printInfo("Installment amount: ");
        paymentScheduleInfo.setInstallmentAmount(scInstAmo.nextDouble());


        printInfo("Date of first installment: ");
        paymentScheduleInfo.setFirstDueDate(scFirstDate.next());

        return paymentScheduleInfo;
    }

}