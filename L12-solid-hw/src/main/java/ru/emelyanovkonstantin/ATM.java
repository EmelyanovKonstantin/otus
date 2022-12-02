package ru.emelyanovkonstantin;

import ru.emelyanovkonstantin.exaptions.EpmtyCellExeption;
import ru.emelyanovkonstantin.exaptions.WithdrawalAmountExaption;

import java.util.*;

public class ATM {
    private final CellFactory cellFactory;
    private Map<Nominal, Cell> cellMap = new EnumMap(Nominal.class);
    public ATM(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }
    public void start() {
        for (Nominal nominal : Nominal.values()) {
            cellMap.put(nominal, cellFactory.createCell(nominal));
        }
    }
    public void putBanknote(Banknote banknote) {
        if (cellMap.containsKey(banknote.getNominal())) {
            Cell targetCell = cellMap.get(banknote.getNominal());
            targetCell.putBanknote(banknote);
            System.out.println("Put in the ATM : " + banknote.getNominalValue() );
        }

    }

   public List<Banknote> getWithdrawal(int withdrawalSum) throws WithdrawalAmountExaption {
        if ( withdrawalSum < getAmount()) {
            List<Banknote> banknoteList = new ArrayList<>();
            for (Nominal nominal : Nominal.values()) {
                int integerPart = withdrawalSum / nominal.getNominal();
                if (integerPart > 0) {
                    Cell cell = cellMap.get(nominal);
                    if (cell.getBanknoteQuantity() > 0) {
                        int quantity = Math.min(cell.getBanknoteQuantity(), integerPart);
                        for (int k = 0; k < quantity; k++) {
                            try {
                                Banknote banknote = cell.getBanknote();
                                banknoteList.add(banknote);
                            } catch (EpmtyCellExeption e) {
                                quantity = k;
                                break;
                            }
                        }
                        withdrawalSum -= nominal.getNominal()*quantity;
                    }
                }
            }
            if (withdrawalSum != 0) {
                for (Banknote banknote : banknoteList) {
                    putBanknote(banknote);
                }
                throw new WithdrawalAmountExaption("It is impossible to issue the amount");
            } else {
                return banknoteList;
            }
        } else {
            throw new WithdrawalAmountExaption("There is not required amount");
        }
   }

   public int getAmount() {
        int sum = 0;
        for (Nominal nominal : Nominal.values()) {
            Cell cell = cellMap.get(nominal);
            sum += cell.cellSum;
        }
        return sum;
   }
}
