package GUI;

import General.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Board2PlayersController implements Initializable{

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

    private Stage stage;

    private MainFor2 Game;

    public Board2PlayersController() {
        
    }

    public void setPlayerName(String player1, String player2){
        firstPlayerName.setText(player1);
        secondPlayerName.setText(player2);
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void makeGame(){
        Game = new MainFor2(firstPlayerName.getText(), secondPlayerName.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
