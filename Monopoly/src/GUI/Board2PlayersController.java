package GUI;

import Cells.*;
import General.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Properties;

public class Board2PlayersController extends Thread{

    @FXML
    private Label firstPlayerName;

    @FXML
    private ComboBox<Property> properties1CB;

    @FXML
    private Label balance1;

    @FXML
    private Label currentCell1;

    @FXML
    private Label inPrison1;

    @FXML
    private Label secondPlayerName;

    @FXML
    private ComboBox<Property> properties2CB;

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

    @FXML
    private Label sum;

    @FXML
    private Label firstResult;

    @FXML
    private Label secondResult;
    Player player1;
    Player player2;

    Board board = new Board();
    Stage stage;

    Player runningPlayer;

    public Board2PlayersController() throws InterruptedException {
        start();
    }

    @FXML
    public void handluj(){

    }

    @FXML
    public void kup(){


        if (playerCell(runningPlayer) instanceof Property) {
            if(!((Property) playerCell(runningPlayer)).isBought()) {
                if (runningPlayer == player1) {
                    ((Property) playerCell(runningPlayer)).buyCity(player1);
                    balance1.setText("" + player1.getBalance());
                    properties1CB.getItems().addAll((Property) playerCell(runningPlayer));
                } else {
                    ((Property) playerCell(runningPlayer)).buyCity(player2);
                    balance2.setText("" + player2.getBalance());
                }
            }

        }
        refreshPlayerAtribiutes();
    }

    @FXML
    public void rzucKostka(){
        if(!runningPlayer.isDrawn()) {
            int result1 = runningPlayer.getCube1().draw();
            int result2 = runningPlayer.getCube2().draw();

            firstResult.setText("" + result1);
            secondResult.setText("" + result2);

            sum.setText("" + (result1 + result2));

            if (runningPlayer.getCurrentCell() + result1 + result2 > 39) {
                runningPlayer.setCurrentCell(runningPlayer.getCurrentCell() + result1 + result2 - 40);
                if (runningPlayer == player1) {
                    player1.plusMoney(400);
                    balance1.setText("" + player1.getBalance());
                } else {
                    player2.plusMoney(400);
                    balance2.setText("" + player2.getBalance());
                }
            } else {
                runningPlayer.setCurrentCell(runningPlayer.getCurrentCell() + result1 + result2);
            }
        }
        runningPlayer.setDrawn(true);

        refreshPlayerAtribiutes();
    }

    @FXML
    public void koniecRuchu(){
        if (runningPlayer.isDrawn()) {
            if (runningPlayer == player1) {
                runningPlayer = player2;
            } else {
                runningPlayer = player1;
            }

            runningPlayer.setDrawn(false);
        }
        firstResult.setText("-");
        secondResult.setText("-");

        sum.setText("-");

       refreshPlayerAtribiutes();
    }

    public Cell playerCell(Player player){
        return board.getBoardCells().get(player.getCurrentCell());
    }
    public void setPlayerName(String player1, String player2){
        firstPlayerName.setText(player1);
        secondPlayerName.setText(player2);
    }

    public void setPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setRunningPlayer(Player player){
        runningPlayer = player;
    }

    public void setCurrentPlayer(){
        currentPlayer.setText(runningPlayer.getName());
    }

    public void setCurrentField(){
        currentCell.setText(playerCell(runningPlayer).getName());
    }

    public void setCurrentCellIndex(){
        currentCellIndex.setText(String.valueOf(playerCell(runningPlayer).getIndex()+1));
    }

    public void setCurrentCellPrice(){
        if(playerCell(runningPlayer) instanceof Property){
            currentCellPrice.setText(String.valueOf(((Property) playerCell(runningPlayer)).getPrice()));
        }
        else{
            currentCellPrice.setText("-");
        }
    }

    public void setCurrentCellRent(){
        if(playerCell(runningPlayer) instanceof Property){
            currentCellRent.setText(String.valueOf(((Property) playerCell(runningPlayer)).getRent()));
        }
        else{
            currentCellRent.setText("-");
        }
    }

    public void setOwnerOfCell(){
        if (runningPlayer == player1){
            if (player2.getCities() != null){
                if(player2.getCities().contains(playerCell(runningPlayer))){
                    ownerOfCell.setText(player2.getName());
                }
            }
            if (runningPlayer.getCities() != null){
                if(runningPlayer.getCities().contains(playerCell(runningPlayer))){
                    ownerOfCell.setText(runningPlayer.getName());
                }
                else{
                    ownerOfCell.setText("-");
                }
            }
            else{
                ownerOfCell.setText("-");
            }
        }
        else{
            if (player1.getCities() != null){
                if(player2.getCities().contains(playerCell(runningPlayer))){
                    ownerOfCell.setText(player2.getName());
                }
            }
            if (runningPlayer.getCities() != null){
                if(runningPlayer.getCities().contains(playerCell(runningPlayer))){
                    ownerOfCell.setText(runningPlayer.getName());
                }
                else{
                    ownerOfCell.setText("-");
                }
            }
            else{
                ownerOfCell.setText("-");
            }
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void run(){
  /*      while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(player1 != null && player2 != null && runningPlayer != null){
                refreshPlayerAtribiutes();
            }
        }   */
    }

    private void refreshPlayerAtribiutes() {

        balance1.setText("" + player1.getBalance());
        currentCell1.setText("" + (player1.getCurrentCell() + 1));
        inPrison1.setText("" + player1.isInPrison());

        balance2.setText("" + player2.getBalance());
        currentCell2.setText("" + (player2.getCurrentCell() + 1));
        inPrison2.setText("" + player2.isInPrison());


        setCurrentPlayer();
        setCurrentField();
        setCurrentCellIndex();
        setCurrentCellPrice();
        setCurrentCellRent();
        setOwnerOfCell();
    }
}
