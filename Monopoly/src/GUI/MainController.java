package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button start;

    @FXML
    private Button exit;

    @FXML
    void exitGame(ActionEvent event) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    @FXML
    void startGame(ActionEvent event) throws IOException {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();

        FXMLLoader startGameLoader = new FXMLLoader(getClass().getResource("FXML/numberOfPlayers.fxml"));
        Parent startGamePane = startGameLoader.load();
        Scene scene = new Scene(startGamePane);

        stageTheEventSourceNodeBelongs.setScene(scene);
    }



}
