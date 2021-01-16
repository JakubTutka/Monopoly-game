package Cells;

import General.Player;

public class Tax extends Cell{

    private int tax;

    public Tax(int index, int tax) {
        super(index, CellType.TAX, "TAX");
        this.tax = tax;
    }

    public void payTax(Player player) {
        System.out.println("Paying the tax: " + tax);
        player.minusMoney(tax);
    }
}
