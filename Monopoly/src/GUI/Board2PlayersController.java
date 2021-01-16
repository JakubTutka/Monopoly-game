package GUI;

import Cells.Property;
import General.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Board2PlayersController extends Thread{

    @FXML
    private Label firstPlayerName;

    @FXML
    private ComboBox<?> properties1CB;

    @FXML
    private Label balance1;

    @FXML
    private Label currentCell1;

    @FXML
    private Label inPrison1;

    @FXML
    private Label secondPlayerName;

    @FXML
    private ComboBox<?> properties2;

    @FXML
    private Label balance2;

    @FXML
    private Label currentCell2;

    @FXML
    private Label inPrison2;

    @FXML
    private Label currentPlayer;

    @FXML
    private Label currentCell;

    @FXML
    private Label currentCellIndex;

    @FXML
    private Label currentCellPrice;

    @FXML
    private Label currentCellRent;

    @FXML
    private Label ownerOfCell;

    Player player1;
    Player player2;

    Board board = new Board();
    Stage stage;

    public Board2PlayersController() throws InterruptedException {
        start();
    }

    public void setPlayerName(String player1, String player2){
        firstPlayerName.setText(player1);
        secondPlayerName.setText(player2);
    }

    public void setPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setCurrentPlayer(Player player){
        currentPlayer.setText(player.getName());
    }

    public void setCurrentField(Player player){
        currentCell.setText(board.getBoardCells().get(player.getCurrentCell()).getName());
    }

    public void setCurrentCellIndex(Player player){
        currentCellIndex.setText(String.valueOf(board.getBoardCells().get(player.getCurrentCell())));
    }

    public void setCurrentCellPrice(Player player){
        if(board.getBoardCells().get(player.getCurrentCell()) instanceof Property){
            currentCellPrice.setText(String.valueOf(((Property) board.getBoardCells().get(player.getCurrentCell())).getPrice()));
        }
        else{
            currentCellPrice.setText("-");
        }
    }

    public void setCurrentCellRent(Player player){
        if(board.getBoardCells().get(player.getCurrentCell()) instanceof Property){
            currentCellRent.setText(String.valueOf(((Property) board.getBoardCells().get(player.getCurrentCell())).getRent()));
        }
        else{
            currentCellRent.setText("-");
        }
    }

    public void setOwnerOfCell(Player player){
        if (player == player1){
            if(player2.getCities().contains(board.getBoardCells().get(player.getCurrentCell()))){
                ownerOfCell.setText(player2.getName());
            }
            else if(player.getCities().contains(board.getBoardCells().get(player.getCurrentCell()))){
                ownerOfCell.setText(player.getName());
            }
        }
        else{
            if(player1.getCities().contains(board.getBoardCells().get(player.getCurrentCell()))){
                ownerOfCell.setText(player2.getName());
            }
            else if(player.getCities().contains(board.getBoardCells().get(player.getCurrentCell()))){
                ownerOfCell.setText(player.getName());
            }
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void run(){
        while(true){
            if(player1 != null && player2 != null){

            }
        }
    }
}
