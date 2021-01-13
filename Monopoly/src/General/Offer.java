package General;

import Cells.Property;

public class Offer {

    private int price;
    private boolean isExchange;
    Player kupiec;
    Player sprzedajcy;
    Property kartaKupca;
    Property kartaSprzedajacego;


    public Offer(Player kupiec, Player sprzedajacy, Property property, int price) {
        this.kupiec = kupiec;
        this.sprzedajcy = sprzedajacy;
        this.kartaKupca = property;
        this.price = price;
        this.isExchange = false;
    }

    public Offer(Player kupiec, Player sprzedajacy, Property kartaKupca, Property kartaSprzedajacego) {
        this.kupiec = kupiec;
        this.sprzedajcy = sprzedajacy;
        this.kartaKupca = kartaKupca;
        this.kartaSprzedajacego = kartaSprzedajacego;
        this.isExchange = true;
    }

    public boolean isExchange() { return isExchange; }

    public void setExchange(boolean exchange) { isExchange = exchange; }

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
        return kartaKupca;
    }

    public void setKupowane(Property kupowane) {
        this.kartaKupca = kartaKupca;
    }

    public Property getSprzedawane() {
        return this.kartaSprzedajacego;
    }

    public void setSprzedawane(Property sprzedawane) {
        this.kartaSprzedajacego = kartaSprzedajacego;
    }
}
