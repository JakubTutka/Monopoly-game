package GUI;

import General.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Board2PlayersController{

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

    private Player player1;
    private Player player2;

    public void setPlayerName(String player1, String player2){
        firstPlayerName.setText(player1);
        secondPlayerName.setText(player2);
    }
    public void startGame(){

    }
}
