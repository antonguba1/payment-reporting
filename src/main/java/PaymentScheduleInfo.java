package com.company.model;

public class PaymentScheduleInfo {

    String firstDueDate;
    private int numberOfInstallments;
    private double installmentAmount;

    public PaymentScheduleInfo() {

    }

    public void setFirstDueDate(String firstDueDate) {
        this.firstDueDate = firstDueDate;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public String getFirstDueDate() {
        return firstDueDate;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }
}