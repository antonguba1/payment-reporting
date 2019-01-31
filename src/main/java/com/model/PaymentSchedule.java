package com.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentSchedule {

    private PaymentScheduleInfo paymentScheduleInfo;
   // private double numberOfInstallments;
    private double actualTotalAmount;
    private double expectedTotalAmount;
    private List<Installment> installmentList = new ArrayList<>();


    public PaymentSchedule(PaymentScheduleInfo paymentScheduleInfo, double actualTotalAmount, double expectedTotalAmount, List<Installment> installmentList) {
        this.paymentScheduleInfo = paymentScheduleInfo;
      //  this.numberOfInstallments = numberOfInstallments;
        this.actualTotalAmount = actualTotalAmount;
        this.expectedTotalAmount = expectedTotalAmount;
        this.installmentList = installmentList;
    }

    public PaymentSchedule() {

    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    public void setPaymentScheduleInfo(PaymentScheduleInfo paymentScheduleInfo) {
        this.paymentScheduleInfo = paymentScheduleInfo;
    }

    public PaymentScheduleInfo getPaymentScheduleInfo() {
        return paymentScheduleInfo;
    }

    public double getExpectedTotalAmount() {
        return paymentScheduleInfo.getInstallmentAmount()*paymentScheduleInfo.getNumberOfInstallments();
            }

    public double getActualTotalAmount() {
        double sum = 0;

        for (Installment installment : installmentList) {
            sum += installment.getActualAmount();
        }
        return sum;
    }

    public double getArrearOfPayment() {
        Date actualDate = new Date();
        double actualAmount = 0;
        double expectedAmount = 0;

        for (Installment installment : installmentList) {
            if (installment.getDueDate().before(actualDate)) {
                actualAmount += installment.getActualAmount();
                expectedAmount += installment.getExpectedAmount();
            }
        }

        return expectedAmount - actualAmount;
    }


    public void setActualTotalAmount(double actualTotalAmount) {
        this.actualTotalAmount = actualTotalAmount;
    }

    public void setExpectedTotalAmount(double expectedTotalAmount) {
        this.expectedTotalAmount = expectedTotalAmount;
    }

}
