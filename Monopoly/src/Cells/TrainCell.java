package Cells;

import General.Player;

public class TrainCell extends Cell {

    private String name;
    private int price;
    private boolean isBought;
    private int rent;

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public TrainCell(int index, String name, int price) {
        super(index, CellType.TRAIN);
        this.name = name;
        this.price = price;
        this.isBought = false;
        this.rent = 50;
    }

    public void buyingCity(Player player) {
        if (isBought == false && player.getBalance() >= this.price) {
            System.out.println("Buying property number " + getIndex());
            player.minusMoney(this.price);
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
