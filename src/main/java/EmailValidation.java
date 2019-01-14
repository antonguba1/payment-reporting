package com.company.model;

public class EmailValidation {


    public boolean validateEmail(String email) {

        if (email.contains("@") && email.contains("."))
            return true;
        else return false;
    }
}