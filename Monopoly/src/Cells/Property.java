package Cells;

import General.*;

import java.util.HashMap;

public class Property extends Cell {
    private int rent;
    private int price;
    private Nationality nationality;
    private boolean isBought;

    // setters and getters


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Property(int index, CellType cellType, String name, int price, int rent, Nationality nationality) {
        super(index, cellType, name);
        this.rent = rent;
        this.price = price;
        this.nationality = nationality;
        this.isBought = false;
    }

    public void buyCity(Player player) {
        if (isBought == false && player.getBalance() >= price) {
            System.out.println("Buying property number " + (getIndex()+1) + ": " + getName());
            player.minusMoney(price);
            player.addCity(this);
            this.isBought = true;
        }
    }

    public void payRent(Player visitor, Player owner, Board temporarySolution) {
        if (owner.getNationalityCounter().get(getNationality()) == temporarySolution.getFullNationality().get(getNationality()) && getNationality() != Nationality.KOLEJE) {
            // ta funkcja jest na pewno do zmiany - nie wiem jak się inaczej odwołać do hashmapy która jest na planszy z liczbą pól danej narodowości nie podając jej jako argumentu
            if (visitor.getBalance() >= 2 * getRent()) {
                visitor.minusMoney(2 * getRent());
                owner.plusMoney(2 * getRent());
            }
        } else if (getNationality() == Nationality.KOLEJE) {
            int switchCounter = owner.getNationalityCounter().get(Nationality.KOLEJE);
            int trainRent = switch (switchCounter) {
                case 2 -> 100;
                case 3 -> 200;
                case 4 -> 400;
                default -> 50;
            };
            if (visitor.getBalance() >= trainRent) {
                visitor.minusMoney(trainRent);
                owner.plusMoney(trainRent);
            }
        } else {
            if (visitor.getBalance() >= getRent()) {
                visitor.minusMoney(getRent());
                owner.plusMoney(getRent());
            }
        }
    }
}
