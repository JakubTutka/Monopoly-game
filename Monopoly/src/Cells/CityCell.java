package Cells;

import General.Player;

public class CityCell extends Cell{
    private int rent;
    private String name;
    private int price;
    private Nationality nationality;
    private boolean isBought;

    public int getPrice() { return this.price; }

    public int getRent() {
        return this.rent;
    }

    public CityCell(int index, String name, int price, int rent, Nationality nationality){
        super(index, CellType.CITY);
        this.rent = rent;
        this.name = name;
        this.price = price;
        this.nationality = nationality;
        this.isBought = false;
    }

    public void buyingCity(Player player) {
        if (isBought == false && player.getBalance() >= price) {
            System.out.println("Buying property number " + getIndex() + ": " + this.name);
            player.minusMoney(price);
            player.addingCity(this);
            this.isBought = true;
        }
    }

    public void payingRent(Player owner, Player visitor) {
        if (visitor.getBalance() >= getRent()) {
            visitor.minusMoney(getRent());
            owner.plusMoney(getRent());
        }
    }
}
