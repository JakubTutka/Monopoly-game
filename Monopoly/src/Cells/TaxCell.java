package Cells;

public class TaxCell extends Cell{

    private int tax;

    public TaxCell(int index, int tax) {
        super(index, CellType.TAX);
        this.tax = tax;
    }
}
