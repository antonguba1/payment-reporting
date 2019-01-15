package com.service;

import com.model.EmailValidation;
import com.model.User;
import com.utility.Loger;

import java.util.Scanner;

public class ReadUserService {

    private EmailValidation emailValidation = new EmailValidation();

    public User createUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String name;
        String email;

        System.out.println("Enter your following data:");

        do {
            System.out.println("\nEnter your email:");
            email = scanner.nextLine();
        }while(!emailValidation.validateEmail(email));

        user.setEmail(email);

        System.out.println("Name: " );
        name = scanner.nextLine();
        user.setName(name);

        Loger.printInfo("User created. " + user);
        return user;
    }

}
