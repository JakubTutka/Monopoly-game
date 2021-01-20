package Cells;

public abstract class Cell{
    private int index;
    private CellType cellType;
    private String name;

    public int getIndex(){
        return index;
    }

    public CellType getCellType(){
        return cellType;
    }

    public String getName(){
        return name;
    }

    public Cell(int index, CellType cellType, String name){
        this.index = index;
        this.cellType = cellType;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
