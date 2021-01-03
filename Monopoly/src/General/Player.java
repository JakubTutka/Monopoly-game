package General;

import Cells.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Player {

    private int number;
    private int balance;
    private boolean inPrison;
    private int currentCell;
    private Set<Cell> cities;
    private String colour;
    private HashMap<Nationality, Integer> nationalityCounter = new HashMap<Nationality, Integer>();

    Dice cube1;
    Dice cube2;

    public Player(int number, String colour) {
        this.number = number;
        this.colour = colour;
        this.balance = 3000;
        this.currentCell = 0;
        for(Nationality l:Nationality.values()) {
            nationalityCounter.put(l, 0);
        }
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

    public HashMap<Nationality, Integer> getNationalityCounter() {
        return this.nationalityCounter;
    }

    public int getCurrentCell() {return this.currentCell;}

    public void addingCity(Property card) {
        cities.add(card);
        int tmp = nationalityCounter.get(card.getNationality()) + 1;
        nationalityCounter.replace(card.getNationality(), tmp);
    }

    public void removingCity(Property card) {
        cities.remove(card);
        int tmp = nationalityCounter.get(card.getNationality()) - 1;
        nationalityCounter.replace(card.getNationality(), tmp);
    }

    public void move() {
        this.currentCell += drawDices(cube1, cube2);
    }

    public void trade(Player trader, Property card) {
        int proposalPrice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Buy(1) or sell(2)?");
        int tradeDecision = scan.nextInt();
        switch (tradeDecision) {
            case 1:
                System.out.println("Proposal price: ");
                proposalPrice = scan.nextInt();
                // tutaj będzie hardkor z akceptowaniem, ale to się ruszy jak się będzie
                // miało jakieś GUI akceptowanie przez drugiego gościa etc
                // ale w sumie ja bym to na razie zostawił mniej więcej do czasu aż będziemy mieli większość gotową
                this.removingCity(card);
                trader.addingCity(card);
                this.minusMoney(proposalPrice);
                trader.plusMoney(proposalPrice);
                break;
            case 2:
                System.out.println("Proposal price: ");
                proposalPrice = scan.nextInt();
                trader.removingCity(card);
                this.addingCity(card);
                trader.minusMoney(proposalPrice);
                this.plusMoney(proposalPrice);
                break;
        }
    }
}
