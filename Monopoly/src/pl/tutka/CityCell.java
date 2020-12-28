package pl.tutka;

public class CityCell extends Cell{
    private String name;
    private int price;
    private Nationality nationality;

    public int getPrice() { return price; }

    public CityCell(int index, String name, int price, Nationality nationality){
        super(index, CellType.CITY);
        this.name = name;
        this.price = price;
        this.nationality = nationality;
    }
}
