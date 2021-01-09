package General;

import Cells.*;

import java.util.*;

public class Player {

    private int number;
    private int balance;
    private boolean inPrison;
    private int currentCell;
    private Set cities;
    private String colour;
    private HashMap<Nationality, Integer> nationalityCounter = new HashMap<Nationality, Integer>();
    private List oferty = new LinkedList<Offer>();

    Dice cube1;
    Dice cube2;
    Offer propo;

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

    public void addOffer(Offer propo) {
        oferty.add(propo);
    }

    public void printOffer(Offer propo) {

    }
    public void acceptSell() {

    }

    public void acceptExchange(Offer propo) {
        this.removingCity(propo.sprzedawane);
        propo.kupiec.addingCity(propo.kupowane);
        oferty.remove(propo);
    }

    public void rejectOffer() {
        oferty.remove(propo);
    }

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

    public void trade(Player trader, Property card, Property myProperty) {
        int proposalPrice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Buy(1) or exchange(2)?");
        int tradeDecision = scan.nextInt();
        switch (tradeDecision) {
            case 1:
                System.out.println("Proposal price: ");
                proposalPrice = scan.nextInt();
                // tutaj będzie hardkor z akceptowaniem, ale to się ruszy jak się będzie
                // miało jakieś GUI akceptowanie przez drugiego gościa etc
                // ale w sumie ja bym to na razie zostawił mniej więcej do czasu aż będziemy mieli większość gotową
                propo = new Offer(this, trader, card, proposalPrice);
                trader.oferty.add(propo);
                /*this.removingCity(card);
                trader.addingCity(card);
                this.minusMoney(proposalPrice);
                trader.plusMoney(proposalPrice);*/
                break;
            case 2:
                propo = new Offer(this, trader, myProperty, card);
                trader.oferty.add(propo);
                /*trader.removingCity(card);
                this.addingCity(card);*/
                break;
        }
    }
}
