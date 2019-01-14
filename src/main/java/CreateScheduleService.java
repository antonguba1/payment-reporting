package com.company.service;
import com.company.model.EmailValidation;
import com.company.model.Installment;
import com.company.model.PaymentScheduleInfo;
import com.company.User;
import java.util.List;
import java.util.Scanner;
import com.company.service.ReadScheduleService;

import static com.company.utility.Loger.printInfo;



public class CreateScheduleService {

    User user;
    private EmailValidation emailValidation = new EmailValidation();



    public User createSchedule() {

        getData();
        PaymentScheduleInfo paymentScheduleInfo = new ReadScheduleService().getDatasToInstallments();



        return user;
    }



    private User getData() {

        user = new User();

        String name;
        String email;

        Scanner scanner = new Scanner(System.in);
        Scanner scName = new Scanner(System.in);

        printInfo("Enter your following datas:");
        do {
            printInfo("Enter your email:");
            email = scanner.nextLine();
            emailValidation.validateEmail(email);

        }while(emailValidation.validateEmail(email) == false);
        user.setEmail(email);

        printInfo("Name: " );
        name = scName.nextLine();
        user.setName(name);

        return user;
    }





    private List<Installment> generateInstallments() {

        List listOfInstallments = user.getListOfInstallments();
        PaymentScheduleInfo paymentScheduleInfo = new PaymentScheduleInfo();

        int numberOfInstallments = paymentScheduleInfo.getNumberOfInstallments();

        Installment installment = new Installment(paymentScheduleInfo.getFirstDueDate(), paymentScheduleInfo.getInstallmentAmount());


        for (int i = 1; i <= numberOfInstallments; i++) {
            Installment installment = new Installment(date, installmentAmount);
            result.add(installment);

        }
    }
    public static void main(String[] args) {


        CreateScheduleService test = new CreateScheduleService();


        test.createSchedule();
    }
}