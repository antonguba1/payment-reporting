package com.service;

import com.model.User;

import java.util.List;

public class WritePaymentRaportService {

    public void generateRaport(List<User> userList) {


        for (User user : userList) {
            user.getName();  //imie do excela
            user.getEmail();  //email do excela
            user.getPaymentSchedule().getArrearOfPayment(); // pobranie zaleglosci

        }
    }
}
