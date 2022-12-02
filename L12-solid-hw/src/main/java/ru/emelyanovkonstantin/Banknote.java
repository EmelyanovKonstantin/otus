package ru.emelyanovkonstantin;

public class Banknote {
    private Nominal nominal;
    public Banknote(Nominal nominal) {
        this.nominal = nominal;
    }

    public Nominal getNominal() {
        return nominal;
    }
    public int getNominalValue() {
        return nominal.getNominal();
    }
}
