package com.service;

import com.model.EmailValidation;
import com.model.User;
import com.utility.Loger;
import com.utility.ScannerUtility;


public class ReadUserService {

    private EmailValidation emailValidation = new EmailValidation();

    public ReadUserService() {

    }

    public User createUser() {
        ScannerUtility scannerUtility = new ScannerUtility();
        User user = new User();

        String name;
        String email;

        System.out.println("Enter your following data:");

        do {
            System.out.println("\nEnter your e-mail:");
            email = scannerUtility.scanString();
        }while(!emailValidation.validateEmail(email));

        user.setEmail(email);

        System.out.println("Enter your name: " );
        name = scannerUtility.scanString();
        user.setName(name);

        Loger.printInfo("User created. " + user);
        return user;
    }

}
