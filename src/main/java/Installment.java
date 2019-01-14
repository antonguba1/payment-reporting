package com.company.model;


public class Installment {

    private String dueDate;
    private double expectedAmount;
    private double actualAmount;

    public Installment() {

    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }


}