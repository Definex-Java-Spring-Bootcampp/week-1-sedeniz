package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.VechileLoan;
import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;

public class LoanFactory {

    public static Loan createLoan(LoanType type, BigDecimal amount, Integer installment, Double interestRate) {
        return switch (type) {
            case IHTIYAC_KREDISI -> new ConsumerLoan(amount, installment, interestRate);
            case KONUT_KREDISI -> new HouseLoan(amount, installment, interestRate);
            case ARAC_KREDISI -> new VechileLoan(amount, installment, interestRate);
            default -> throw new IllegalArgumentException("Unknown Loan Type: " + type);
        };
    }
}
