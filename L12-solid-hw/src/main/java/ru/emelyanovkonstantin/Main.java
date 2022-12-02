package ru.emelyanovkonstantin;

import ru.emelyanovkonstantin.exaptions.WithdrawalAmountExaption;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CellFactory cellFactory = new CellFactory();
        ATM atm = new ATM(cellFactory);
        atm.start();

        System.out.println("The remaining funds in the ATM : " + atm.getAmount());
        Banknote banknote = new Banknote(Nominal.HUNDRED);
        Banknote banknote1 = new Banknote(Nominal.FIFTY);
        Banknote banknote2 = new Banknote(Nominal.FIFTY);
        Banknote banknote3 = new Banknote(Nominal.TEN);
        Banknote banknote4 = new Banknote(Nominal.TEN);
        Banknote banknote5 = new Banknote(Nominal.TEN);
        Banknote banknote6 = new Banknote(Nominal.TEN);
        Banknote banknote7 = new Banknote(Nominal.TEN);
        Banknote banknote8 = new Banknote(Nominal.TEN);
        atm.putBanknote(banknote);
        atm.putBanknote(banknote1);
        atm.putBanknote(banknote2);
        atm.putBanknote(banknote3);
        atm.putBanknote(banknote4);
        atm.putBanknote(banknote5);
        atm.putBanknote(banknote6);
        atm.putBanknote(banknote7);
        atm.putBanknote(banknote8);
        System.out.println("The remaining funds in the ATM : " + atm.getAmount());

        try {
            List<Banknote> banknoteList = atm.getWithdrawal(110);
            banknoteList.stream().map(b -> "A banknote has been issued : " + b.getNominalValue()).forEach(System.out::println);
        } catch (WithdrawalAmountExaption e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The remaining funds in the ATM : " + atm.getAmount());
    }
}