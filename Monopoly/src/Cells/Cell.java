package Cells;

public abstract class Cell{
    private int index;
    private CellType cellType;

    public int getIndex(){
        return index;
    }

    public CellType getCellType(){
        return cellType;
    }

    public Cell(int index, CellType cellType){
        this.index = index;
        this.cellType = cellType;
    }

}
