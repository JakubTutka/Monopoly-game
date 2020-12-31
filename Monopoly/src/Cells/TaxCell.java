package Cells;

import General.Player;

public class TaxCell extends Cell{

    private int tax;

    public TaxCell(int index, int tax) {
        super(index, CellType.TAX);
        this.tax = tax;
    }

    public void payTax(Player player) {
        System.out.println("Paying the tax: " + tax);
        player.minusMoney(tax);
    }
}
