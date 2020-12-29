import Cells.*;
import java.util.Random;

class Dice {
    private int currentValue;

    public int draw() {
        Random r = new Random();
        this.currentValue = 1 + r.nextInt(6);
        return currentValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public static void main(String[] args) {
        Dice cube = new Dice();
        for (int i = 0; i < 100; i++) {
            System.out.println(cube.draw());
        }
    }

}
