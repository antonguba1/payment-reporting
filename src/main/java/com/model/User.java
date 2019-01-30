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
        double rest;
        int numberOfInstallments = paymentSchedule.getInstallmentList().size();

        for (int i = 0; i < numberOfInstallments - 1; i++) {

            double actualAmount = paymentSchedule.getInstallmentList().get(i).getActualAmount();
            double expectedAmount = paymentSchedule.getInstallmentList().get(i).getExpectedAmount();

            if (actualAmount < expectedAmount) {

                rest = expectedAmount - actualAmount;
                paymentSchedule.getInstallmentList().get(i + 1).setRealExpectedAmount(paymentSchedule.getInstallmentList().get(i + 1).getExpectedAmount() + rest);
                for (int j = 1; j < numberOfInstallments - 1; j++) {
                    paymentSchedule.getInstallmentList().get((i + 1) + j).setRealExpectedAmount(paymentSchedule.getInstallmentList().get((i + 1) + j).getExpectedAmount());
                }
                return;

            } else if (actualAmount > expectedAmount) {

                rest = expectedAmount - actualAmount;
                paymentSchedule.getInstallmentList().get(i + 1).setRealExpectedAmount(paymentSchedule.getInstallmentList().get(i + 1).getExpectedAmount() + rest);
                for (int j = 1; j < numberOfInstallments - 1; j++) {
                    paymentSchedule.getInstallmentList().get((i + 1) + j).setRealExpectedAmount(paymentSchedule.getInstallmentList().get((i + 1) + j).getExpectedAmount());
                }
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
