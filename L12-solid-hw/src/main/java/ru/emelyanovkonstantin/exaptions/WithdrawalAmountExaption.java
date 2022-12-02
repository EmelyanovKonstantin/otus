package ru.emelyanovkonstantin.exaptions;

public class WithdrawalAmountExaption extends Exception{
    public WithdrawalAmountExaption(String errorMessage) {
        super(errorMessage);
    }
}
