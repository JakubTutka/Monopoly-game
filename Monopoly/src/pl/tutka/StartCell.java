package pl.tutka;

public class StartCell extends Cell{
    private int bonus = 200;
    private CellType type;


    public StartCell() {
        super(1, CellType.START);

    }
}
