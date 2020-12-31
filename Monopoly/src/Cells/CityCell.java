package Cells;

import General.Player;

public class CityCell extends Cell{
    private int rent;
    private String name;
    private int price;
    private Nationality nationality;
    private boolean isBought;

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
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
            System.out.println("Buying property number " + getIndex());
            player.minusMoney(price);
            player.addingCity(this);
            this.isBought = true;
        }
    }

    public void payingRent(Player player1, Player player2) {
        if (player1.getBalance() >= getRent()) {
            player1.minusMoney(getRent());
            player2.plusMoney(getRent());
        }
    }
}
