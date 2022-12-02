package ru.emelyanovkonstantin;

import ru.emelyanovkonstantin.exaptions.EpmtyCellExeption;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private Nominal nominal;
    private List<Banknote> cellList = new ArrayList<>();
    public int cellSum = 0;

    Cell(Nominal nominal) {
        this.nominal = nominal;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public void putBanknote(Banknote banknote) {
        cellList.add(banknote);
        cellSum += nominal.getNominal();
    }

    public Banknote getBanknote() throws EpmtyCellExeption {
        if (!cellList.isEmpty()) {
            Banknote banknote = cellList.remove(0);
            cellSum -= nominal.getNominal();
            return banknote;
        } else {
            throw new EpmtyCellExeption("Cell empty: " + nominal.getNominal());
        }
    }
    public int getBanknoteQuantity() {
        return cellList.size();
    }
}
