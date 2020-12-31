package Cells;

import General.*;

public class StartCell extends Cell{
    private final int bonus = 400;
    private CellType type;

    public StartCell() {
        super(1, CellType.START);
    }

    public void addMoney(Player player) {
        System.out.println("Passing the start, adding bonus money to your account");
        player.plusMoney( bonus);
    }
}
