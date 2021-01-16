package GUI;

import General.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberOfPlayersController {

    @FXML
    private TextField player1TF;

    @FXML
    private TextField player2TF;

    @FXML
    private TextField player3TF;

    @FXML
    private TextField player4TF;

    @FXML
    private Button continueGameButton;

    @FXML
    private RadioButton twoPlayers;

    @FXML
    private RadioButton threePlayers;

    @FXML
    private RadioButton fourPlayers;

    @FXML
    private Label wpiszImiona;

    Player player1;
    Player player2;

    @FXML
    void continueGame(ActionEvent event) throws IOException {
        if (nameSet()){
            Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();

            if (twoPlayers.isSelected()){

                FXMLLoader startGameLoader = new FXMLLoader(getClass().getResource("FXML/board2Players.fxml"));
                Parent startGamePane = (Parent) startGameLoader.load();

                Board2PlayersController board2PlayersController = startGameLoader.getController();
                board2PlayersController.setPlayerName(player1TF.getText(), player2TF.getText());

                player1 = new Player(player1TF.getText(), 1);
                player2 = new Player(player2TF.getText(), 2);

                board2PlayersController.setPlayers(player1, player2);
                board2PlayersController.setCurrentPlayer(player1);
                board2PlayersController.setCurrentField(player1);
                board2PlayersController.setCurrentCellIndex(player1);
                board2PlayersController.setCurrentCellPrice(player1);
                board2PlayersController.setCurrentCellRent(player1);
                board2PlayersController.setOwnerOfCell(player1);

//                board2PlayersController.makeGame();
//                board2PlayersController.setStage(stageTheEventSourceNodeBelongs);
//                board2PlayersController.setCurrentPlayer(player1TF.getText());

                Scene scene = new Scene(startGamePane);

                Stage board = new Stage();
                board.setScene(scene);
                board.setResizable(false);

                stageTheEventSourceNodeBelongs.close();
                board.show();


            }
            else if (threePlayers.isSelected()){
                FXMLLoader startGameLoader = new FXMLLoader(getClass().getResource("FXML/board3Players.fxml"));
                Parent startGamePane = startGameLoader.load();
                Scene scene = new Scene(startGamePane);

                Stage board = new Stage();
                board.setScene(scene);
                board.setResizable(false);

                stageTheEventSourceNodeBelongs.close();
                board.show();
            }
            else {
                FXMLLoader startGameLoader = new FXMLLoader(getClass().getResource("FXML/board4Players.fxml"));
                Parent startGamePane = startGameLoader.load();
                Scene scene = new Scene(startGamePane);

                Stage board = new Stage();
                board.setScene(scene);
                board.setResizable(false);

                stageTheEventSourceNodeBelongs.close();
                board.show();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nie wypełniono wszystkich pól!");
            alert.show();
        }
    }

    @FXML
    void radioCheck(ActionEvent event) {

        if (twoPlayers.isSelected()){
            wpiszImiona.setVisible(true);
            player1TF.setVisible(true);
            player2TF.setVisible(true);
            player3TF.setVisible(false);
            player4TF.setVisible(false);
            continueGameButton.setVisible(true);
        }

        if (threePlayers.isSelected()){
            wpiszImiona.setVisible(true);
            player1TF.setVisible(true);
            player2TF.setVisible(true);
            player3TF.setVisible(true);
            player4TF.setVisible(false);
            continueGameButton.setVisible(true);
        }

        if (fourPlayers.isSelected()){
            wpiszImiona.setVisible(true);
            player1TF.setVisible(true);
            player2TF.setVisible(true);
            player3TF.setVisible(true);
            player4TF.setVisible(true);
            continueGameButton.setVisible(true);
        }

    }
    boolean nameSet(){
        if (twoPlayers.isSelected()){
            if (player1TF.getText().isEmpty() || player2TF.getText().isEmpty()){
                return false;
            }
            return true;
        }

        if(threePlayers.isSelected()){
            if (player1TF.getText().isEmpty() || player2TF.getText().isEmpty() || player3TF.getText().isEmpty()){
                return false;
            }
            return true;
        }

        if(fourPlayers.isSelected()){
            if (player1TF.getText().isEmpty() || player2TF.getText().isEmpty() || player3TF.getText().isEmpty() || player4TF.getText().isEmpty()){
                return false;
            }
            return true;
        }
        return false;
    }
}
