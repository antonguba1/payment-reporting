package com.model;

public class EmailValidation {


    public boolean validateEmail(String email) {

        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            System.out.println("E-mail should constains '@' and '.' . Enter your e-mail again.");
            return false;
        }

    }
}