package com.model;


import java.util.Date;

public class Installment {

    private Date dueDate;
    private double expectedAmount;
    private double actualAmount;

    public Installment() {

    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }


    public void setExpectedAmount(double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "dueDate='" + dueDate + '\'' +
                ", expectedAmount=" + expectedAmount +
                ", actualAmount=" + actualAmount +
                '}';
    }
}