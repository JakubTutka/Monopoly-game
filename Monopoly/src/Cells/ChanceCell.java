package Cells;

import General.Player;

import java.util.Random;

public class ChanceCell extends Cell{

    public ChanceCell(int index) {
        super(index, CellType.CHANCE);
    }

    public void drawingChance(Player player) {
        Random r = new Random();
        int option = r.nextInt(2);
        switch (option) {
            case 0 :
                int lotteryCash = 50 * (1 + r.nextInt(8));
                int plusOrMinus = r.nextInt(2);
                if (plusOrMinus == 0) {
                    System.out.println("Losing " + lotteryCash);
                    player.minusMoney(lotteryCash);
                }
                else {
                    System.out.println("Winning " + lotteryCash);
                    player.plusMoney(lotteryCash);
                }
                break;
            case 1 :
                int lotteryIndexCell = 1 + r.nextInt(40);
                System.out.println("Going to " + lotteryIndexCell + " cell");
                player.setCurrentCell(lotteryIndexCell);

        }
    }
}
