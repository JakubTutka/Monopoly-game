package General;

import java.util.Set;

public class MainFor2 {
    Player player1;
    Player player2;

    Board board;

    Player winner;

    public MainFor2(String player1Name, String player2Name){
        player1 = new Player(player1Name,1);
        player2 = new Player(player2Name,2);

        board = new Board();

        this.startGame();
    }

    public void startGame(){
        player1.setCurrentCell(board.getBoardCells().get(0));
        player2.setCurrentCell(board.getBoardCells().get(0));
    }

}
