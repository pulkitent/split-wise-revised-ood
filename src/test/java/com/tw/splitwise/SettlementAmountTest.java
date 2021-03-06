package com.tw.splitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tw.splitwise.Constant.destinationCurrencyMessage;

class SettlementAmountTest {
    @Test
    @DisplayName("Should stringify amount properly")
    void expectsToStringifyAmounnt() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        CurrencyType sourceCurrencyType = CurrencyType.INR;
        CurrencyType destinationCurrencyType = CurrencyType.INR;
        CurrencyConverter converter = new CurrencyConverter(sourceCurrencyType, destinationCurrencyType);
        String expectedStringifiedAmount = "INR 100.0 Rahul";

        Assertions.assertEquals(expectedStringifiedAmount, settlementAmount.toString(converter));
    }

    @Test
    @DisplayName("Should find whether two settlement amounts are equal or not")
    void expectsToCheckEquality() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        SettlementAmount anotherSettlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));

        Assertions.assertTrue(settlementAmount.equals(anotherSettlementAmount));
    }

    @Test
    @DisplayName("Should compute hash of settlement amount properly")
    void expectedHashToBeComputed() {
        SettlementAmount settlementAmount = new SettlementAmount(100.0, new Friend("Rahul", 100.0, 100.0));
        int expectedHash = -814204880;

        Assertions.assertEquals(expectedHash, settlementAmount.hashCode());
    }
}