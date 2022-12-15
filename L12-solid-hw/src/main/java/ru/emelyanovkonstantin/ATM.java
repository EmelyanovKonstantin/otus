package ru.emelyanovkonstantin;

import ru.emelyanovkonstantin.exaptions.WithdrawalAmountExaption;

import java.util.List;

public interface ATM {
    void putBanknote(Banknote banknote);

    List<Banknote> getWithdrawal(int withdrawalSum) throws WithdrawalAmountExaption;

    int getAmount();
}
