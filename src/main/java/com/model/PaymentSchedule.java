package com.model;

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
}
