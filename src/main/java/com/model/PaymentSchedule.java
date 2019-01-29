package com.model;

import java.util.Date;
import java.util.List;

public class PaymentSchedule {

    private PaymentScheduleInfo paymentScheduleInfo;
    private List<Installment> installmentList;


    public PaymentSchedule(PaymentScheduleInfo paymentScheduleInfo, List<Installment> installmentList) {
        this.paymentScheduleInfo = paymentScheduleInfo;
        this.installmentList = installmentList;
    }


    public List<Installment> getInstallmentList() {
        return installmentList;
    }

    public double getExpectedTotalAmount() {
        int numberOfInstallments = paymentScheduleInfo.getNumberOfInstallments();
        double installmentAmount = paymentScheduleInfo.getInstallmentAmount();

        return numberOfInstallments * installmentAmount;
    }

    public double getActualTotalAmount() {
        double sum = 0;

        for (Installment installment : installmentList) {
            sum += installment.getActualAmount();
        }
        return sum;
    }
/*
    public void transferPayment() {
        double rest = 0;

        for (int i = 0; i < installmentList.size(); i++) {
            if (installmentList.get(i).getActualAmount() < installmentList.get(i).getExpectedAmount()) {

                rest = installmentList.get(i).getExpectedAmount() - installmentList.get(i).getActualAmount();
                installmentList.get(i + 1).setRealExpectedAmount(installmentList.get(i + 1).getExpectedAmount() + rest);

            } else if (installmentList.get(i).getActualAmount() > installmentList.get(i).getExpectedAmount()) {

                rest = installmentList.get(i).getExpectedAmount() - installmentList.get(i).getActualAmount();
                installmentList.get(i + 1).setRealExpectedAmount(installmentList.get(i + 1).getExpectedAmount() + rest);

            } else {

                rest = 0;
                installmentList.get(i + 1).setRealExpectedAmount(installmentList.get(i + 1).getExpectedAmount() + rest);
            }
        }

    }
*/

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

}
