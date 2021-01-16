package Cells;

import General.Player;

import java.util.Random;

public class Chance extends Cell{

    public Chance(int index) {
        super(index, CellType.CHANCE, "Chance");
    }

    public void drawChance(Player player) {
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
                int lotteryIndexCell = 1 + r.nextInt(7);
                int lotterySign = r.nextInt(2);
                if (lotterySign == 0) {
                    System.out.println("Moving back " + lotteryIndexCell + " cells");
                    player.setCurrentCell(player.getCurrentCell() - lotteryIndexCell);
                }
                else {
                    System.out.println("Moving forward " + lotteryIndexCell + " cells");
                    player.setCurrentCell(player.getCurrentCell() + lotteryIndexCell);
                }
        }
    }
}
