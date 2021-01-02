package Cells;

import General.Player;

public class Property extends Cell{
    private int rent;
    private String name;
    private int price;
    private Nationality nationality;
    private boolean isBought;

    public int getPrice() { return this.price; }

    public int getRent() {
        return this.rent;
    }

    public Property(int index, CellType cellType, String name, int price, int rent, Nationality nationality){
        super(index, cellType);
        this.rent = rent;
        this.name = name;
        this.price = price;
        this.nationality = nationality;
        this.isBought = false;
    }

    public void buyCity(Player player) {
        if (isBought == false && player.getBalance() >= price) {
            System.out.println("Buying property number " + getIndex() + ": " + this.name);
            player.minusMoney(price);
            player.addingCity(this);
            this.isBought = true;
        }
    }

    public void payRent(Player player1, Player player2) {
        if (player1.getBalance() >= getRent()) {
            player1.minusMoney(getRent());
            player2.plusMoney(getRent());
        }
    }
}
