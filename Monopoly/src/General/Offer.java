package General;

import Cells.Property;

public class Offer {

    private int price;
    Player kupiec;
    Player sprzedajcy;
    Property kupowane;
    Property sprzedawane;

    public Offer(Player kupiec, Player sprzedajacy, Property property, int price) {
        this.kupiec = kupiec;
        this.sprzedajcy = sprzedajacy;
        this.kupowane = property;
        this.price = price;
    }

    public Offer(Player kupiec, Player sprzedajacy, Property kupowane, Property sprzedawane) {
        this.kupiec = kupiec;
        this.sprzedajcy = sprzedajacy;
        this.kupowane = kupowane;
        this.sprzedawane = sprzedawane;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Player getKupiec() {
        return kupiec;
    }

    public void setKupiec(Player kupiec) {
        this.kupiec = kupiec;
    }

    public Player getSprzedajcy() {
        return sprzedajcy;
    }

    public void setSprzedajcy(Player sprzedajcy) {
        this.sprzedajcy = sprzedajcy;
    }

    public Property getKupowane() {
        return kupowane;
    }

    public void setKupowane(Property kupowane) {
        this.kupowane = kupowane;
    }

    public Property getSprzedawane() {
        return sprzedawane;
    }

    public void setSprzedawane(Property sprzedawane) {
        this.sprzedawane = sprzedawane;
    }
}
