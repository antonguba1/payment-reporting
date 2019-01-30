package com.model;

import com.service.ReadUserService;
import com.utility.Loger;


public class User {

    private String name;
    private String email;
    private PaymentSchedule paymentSchedule;
    private PaymentScheduleInfo paymentScheduleInfo;


    public User() {

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public PaymentScheduleInfo getPaymentScheduleInfo() {
        return paymentScheduleInfo;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printInstallments() {

        for (Installment e : paymentSchedule.getInstallmentList()) {
            Loger.printInfo(e.toString());
        }
    }

    public void transferPayment() {
        double rest = 0;

        for (int i = 0; i < paymentSchedule.getInstallmentList().size() - 1; i++) {

            if (paymentSchedule.getInstallmentList().get(i).getActualAmount() < paymentSchedule.getInstallmentList().get(i).getExpectedAmount()) {

                rest = (paymentSchedule.getInstallmentList().get(i).getExpectedAmount() - paymentSchedule.getInstallmentList().get(i).getActualAmount() / (paymentSchedule.getInstallmentList().size() + 2));
                paymentSchedule.getInstallmentList().get(i + 1).setRealExpectedAmount(paymentSchedule.getInstallmentList().get(i + 1).getExpectedAmount() + rest);
                //tutaj wyżej trzeba od razu podzielic rest przez ilosc rat i dodac do kolejnych obiektow w liscie
                return;

            } else if (paymentSchedule.getInstallmentList().get(i).getActualAmount() > paymentSchedule.getInstallmentList().get(i).getExpectedAmount()) {

                rest = paymentSchedule.getInstallmentList().get(i).getExpectedAmount() - paymentSchedule.getInstallmentList().get(i).getActualAmount();
                paymentSchedule.getInstallmentList().get(i + 1).setRealExpectedAmount(paymentSchedule.getInstallmentList().get(i + 1).getExpectedAmount() + rest);
                //to samo tutaj
                return;

            } else {
                transferPayment();

            }
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", paymentSchedule=" + paymentSchedule +
                '}';
    }
}
