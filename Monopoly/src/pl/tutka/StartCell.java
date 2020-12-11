package pl.tutka;

public class StartCell implements Cell{
    private final int index = 1;
    private int bonus = 200;
    private CellType type = CellType.START;


    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public CellType getType() { return type; }

    public StartCell() {
    }
}
