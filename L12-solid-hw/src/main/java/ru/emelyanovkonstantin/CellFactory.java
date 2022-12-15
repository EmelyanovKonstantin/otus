package ru.emelyanovkonstantin;

public class CellFactory {
    public Cell createCell(Nominal nominal) {
        Cell cell = new Cell(nominal);
        return  cell;
    }
}
