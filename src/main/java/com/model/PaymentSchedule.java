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

}
