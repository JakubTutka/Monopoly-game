import java.security.cert.TrustAnchor;
import java.util.Set;

public class Player {

    private int balance;
    private boolean inPrison;
    private int currentCell;
    private Set cities;
    private String colour;


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isInPrison() {
        return inPrison;
    }

    public void setInPrison() {
        this.inPrison = true;
    }

    public int getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(int currentCell) {
        this.currentCell = currentCell;
    }

    public Set getCities() {
        return cities;
    }

    public void setCities(Set cities) {
        this.cities = cities;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    Dice cube1;
    Dice cube2;

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
}
