package Cells;

import General.Player;

public class GoToJailCell extends Cell{

        public GoToJailCell(int index) {
            super(index, CellType.GOTOJAIL);
        }

        public void playerGoToJail(Player player) {
            System.out.println("Going to the jail :(");
            player.setInPrison();
        }
}
