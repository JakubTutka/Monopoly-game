package General;

import java.util.ArrayList;
import java.util.Set;
import Cells.*;

public class MainFor2 {
    Player player1;
    Player player2;

    Board board;

    Dice dice1;
    Dice dice2;

    Player actual;

    ArrayList<Player> players = new ArrayList<>();

    public MainFor2(String player1Name, String player2Name){
        players.add(player1 = new Player(player1Name,0));
        players.add(player2 = new Player(player2Name,1));

        board = new Board();

        this.startGame();
        int tura = 0;
        while (player1.getBalance() > 0 && player2.getBalance() > 0) {
            if (tura % 2 == 0) {
                actual = player1;
            }
            else {
                actual = player2;
            }
            actual.move();
            if (board.boardCells.get(actual.getCurrentCell()).getCellType() == CellType.CITY) {
                System.out.println("Pole: " + board.boardCells.get(actual.getCurrentCell()).getClass().getName() +
                        " nalezy do: " + board.boardCells.get(actual.getCurrentCell()));
            }
            else if (board.boardCells.get(actual.getCurrentCell()).getCellType() == CellType.START) {
                board.boardCells.get(actual.getCurrentCell());//.addMoney(actual);
            }
            else if (board.boardCells.get(actual.getCurrentCell()).getCellType() == CellType.CHANCE) {

            }

            tura++;
        }
    }

    public void startGame(){
        player1.setCurrentCell(0);
        player2.setCurrentCell(0);
    }

}
