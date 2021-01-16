package Cells;

import General.Player;

public class GoToJail extends Cell{

        public GoToJail(int index) {
            super(index, CellType.GOTOJAIL, "Idziesz do więzienia");
        }

        public void playerGoToJail(Player player) {
            System.out.println("Going to the jail :(");
            player.setInPrison();
        }
}
