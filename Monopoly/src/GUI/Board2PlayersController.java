package GUI;


import Cells.*;
import General.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Board2PlayersController extends Thread implements Initializable {

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

    @FXML
    public void handluj(ActionEvent event) throws IOException {

        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader startGameLoader = new FXMLLoader(getClass().getResource("FXML/tradeStage2Players.fxml"));
        Parent startGamePane = (Parent) startGameLoader.load();

        Trade2PlayersController trade2PlayersController = startGameLoader.getController();
        trade2PlayersController.setPlayers(player1, player2, properties1CB, properties2CB);

        Scene scene = new Scene(startGamePane);

        Stage trade = new Stage();
        trade.setScene(scene);
        trade.setResizable(false);

        trade.showAndWait();

        properties1CB.getItems().removeAll(properties1CB.getItems());
        properties2CB.getItems().removeAll(properties2CB.getItems());

        for (int i = 0; i < player1.getCities().size(); i++){
            properties1CB.getItems().add(player1.getCities().get(i));
        }

        for (int i = 0; i < player2.getCities().size(); i++){
            properties2CB.getItems().add(player2.getCities().get(i));
        }

        refreshPlayerAtribiutes();
    }

    @FXML
    public void kup() {
        if (playerCell(runningPlayer) instanceof Property) {
            if (!((Property) playerCell(runningPlayer)).isBought()) {
                if (runningPlayer == player1) {
                    ((Property) playerCell(runningPlayer)).buyCity(player1);
                    balance1.setText("" + player1.getBalance());
                    properties1CB.getItems().addAll((Property) playerCell(runningPlayer));
                } else {
                    ((Property) playerCell(runningPlayer)).buyCity(player2);
                    balance2.setText("" + player2.getBalance());
                    properties2CB.getItems().addAll((Property) playerCell(runningPlayer));
                }
            }
        }
        refreshPlayerAtribiutes();
    }

    @FXML
    public void rzucKostka(){
        if(!runningPlayer.isDrawn() && !runningPlayer.isInPrison()) {
            int result1 = runningPlayer.getCube1().draw();
            int result2 = runningPlayer.getCube2().draw();

            firstResult.setText("" + result1);
            secondResult.setText("" + result2);

            sum.setText("" + (result1 + result2));

            if (runningPlayer.getCurrentCell() + result1 + result2 > 39) {
                runningPlayer.setCurrentCell(runningPlayer.getCurrentCell() + result1 + result2 - 40);
                if (runningPlayer == player1) {
                    player1.plusMoney(0);
                    balance1.setText("" + player1.getBalance());
                } else {
                    player2.plusMoney(0);
                    balance2.setText("" + player2.getBalance());
                }
            } else {
                runningPlayer.setCurrentCell(runningPlayer.getCurrentCell() + result1 + result2);
            }

            if (playerCell(runningPlayer) instanceof Chance) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (runningPlayer == player1) {
                    ((Chance) playerCell(runningPlayer)).drawChance(player1);
                    balance1.setText("" + player1.getBalance());
                } else {
                    ((Chance) playerCell(runningPlayer)).drawChance(player2);
                    balance2.setText("" + player2.getBalance());
                }
            }

            if (playerCell(runningPlayer) instanceof GoToJail) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (runningPlayer == player1) {
                    ((GoToJail) playerCell(runningPlayer)).playerGoToJail(player1);
                } else {
                    ((GoToJail) playerCell(runningPlayer)).playerGoToJail(player2);
                }
            }

            if (playerCell(runningPlayer) instanceof Tax) {
                if (runningPlayer == player1) {
                    ((Tax) playerCell(runningPlayer)).payTax(player1);
                } else {
                    ((Tax) playerCell(runningPlayer)).payTax(player2);
                }
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
                if (runningPlayer.isInPrison()) {
                    player2.setPrisonCount(runningPlayer.getPrisonCount()-1);
                    if (runningPlayer.getPrisonCount() == 0) {
                        player2.setInPrison(false);
                    }
                }
            } else {
                runningPlayer = player1;
                if (runningPlayer.isInPrison()) {
                    player1.setPrisonCount(runningPlayer.getPrisonCount()-1);
                    if (runningPlayer.getPrisonCount() == 0) {
                        player1.setInPrison(false);
                    }
                }
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

        Random random = new Random();
        boolean whoStarts = random.nextBoolean();

        if(whoStarts){
            setRunningPlayer(player1);
        }
        else{
            setRunningPlayer(player2);
        }
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
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (player1 != null && player2 != null) {
                if (player1.getBalance() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("KONIEC KURWA GRY WYGRAL " + player2.getName());
                    alert.show();
                    stage.close();
                } else if (player2.getBalance() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("CHUJ KONIEC WYGRYWA " + player1.getBalance());
                    alert.show();
                    stage.close();
                }
            }
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread startThread = new Thread() {
            public void run(){
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (player1 != null && player2 != null) {
                        if (player1.getBalance() <= 0) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("KONIEC KURWA GRY WYGRAL " + player2.getName());
                            alert.show();
                            stage.close();
                        } else if (player2.getBalance() <= 0) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("CHUJ KONIEC WYGRYWA " + player1.getBalance());
                            alert.show();
                            stage.close();
                        }
                    }
                }
            }
        };

    }
}
