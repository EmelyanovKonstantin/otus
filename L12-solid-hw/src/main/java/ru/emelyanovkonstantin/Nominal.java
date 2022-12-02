package ru.emelyanovkonstantin;

public enum Nominal {
    FIVE_THOUSAND(5000),
    THOUSAND(1000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TEN(10);
    private int nominal;
    Nominal(int nominal) {
        this.nominal = nominal;
    }
    public int getNominal(){ return nominal;}
}
