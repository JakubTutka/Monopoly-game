package Cells;

import General.*;

public class Start extends Cell{
    private final int bonus = 400;

    public Start() {
        super(0, CellType.START, "START");
    }

    public void addMoney(Player player) {
        System.out.println("Passing the start, adding bonus money to your account");
        player.plusMoney( bonus);
    }
}
