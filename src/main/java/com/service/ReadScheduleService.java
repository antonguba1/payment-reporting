package com.service;



import com.model.PaymentScheduleInfo;
import com.utility.DateUtility;
import com.utility.Loger;

import java.util.Scanner;

import static com.utility.Loger.printInfo;

public class ReadScheduleService {


    protected PaymentScheduleInfo createPaymentScheduleInfo() {

        Scanner scanner = new Scanner(System.in);
        PaymentScheduleInfo paymentScheduleInfo = new PaymentScheduleInfo();

        System.out.println("Number of installments: ");
        paymentScheduleInfo.setNumberOfInstallments(scanner.nextInt());

        System.out.println("Installment amount: ");
        paymentScheduleInfo.setInstallmentAmount(scanner.nextDouble());

        printInfo("Date of first installment: (dd-MM-yyyy)");
        String dateString = scanner.next();
        paymentScheduleInfo.setFirstDueDate(DateUtility.toDate(dateString));

        Loger.printInfo("Created PaymentScheduleInfo: " + paymentScheduleInfo);
        return paymentScheduleInfo;
    }

}