package Cells;

public class TrainCell extends Cell {

    private String name;
    private int price;

    public TrainCell(int index, String name, int price) {
        super(index, CellType.TRAIN);
        this.name = name;
        this.price = price;
    }
}
