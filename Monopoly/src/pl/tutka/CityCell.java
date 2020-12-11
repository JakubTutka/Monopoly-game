package pl.tutka;

public class CityCell implements Cell{
    private int index;
    private String name;
    private int price;
    private CellType type = CellType.CITY;


    @Override
    public int getIndex() { return index; }

    public int getPrice() { return price; }

    @Override
    public CellType getType() { return type; }

    public CityCell(int index, String name, int price){
        this.index = index;
        this.name = name;
        this.price = price;
    }
}
