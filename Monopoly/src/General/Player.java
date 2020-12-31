package General;

import Cells.*;
import java.security.cert.TrustAnchor;
import java.util.Set;

public class Player {

    private int number;
    private int balance;
    private boolean inPrison;
    private int currentCell;
    private Set cities;
    private String colour;

    Dice cube1;
    Dice cube2;

    public Player(int number, String colour) {
        this.number = number;
        this.colour = colour;
        this.balance = 3000;
        this.currentCell = 0;
    }

    public int drawDices(Dice cube1, Dice cube2) {
        int drawed1 = cube1.draw();
        int drawed2 = cube2.draw();
        boolean sameValue;
        if (drawed1 == drawed2) {
            sameValue = true;
        }
        else {
            sameValue = false;
        }
        return drawed1 + drawed2;
    }

    public void plusMoney(int money) {
        this.balance += money;
    }

    public void minusMoney(int money) {
        this.balance += money;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setInPrison() {
        this.inPrison = true;
        this.currentCell = 10;
    }
    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }

    public void addingCity(Cell card) {
        cities.add(card);
    }

    public void move() {
        this.currentCell += drawDices(cube1, cube2);
    }
}
