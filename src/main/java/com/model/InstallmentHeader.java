package com.model;

public enum InstallmentHeader {
    EXPECTED_DATE("Exp. date "),
    EXPECTED_AMOUNT("Exp. amount "),
    ACTUAL_DATE("Actual date "),
    ACTUAL_AMOUNT("Actual amount ");

    private String name;

    InstallmentHeader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
