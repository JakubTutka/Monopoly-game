package GUI;

import Cells.Property;
import General.*;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Trade2PlayersController{

    private Player player1;
    private Player player2;

    private ComboBox<Property> player1CB;
    private ComboBox<Property> player2CB;

    public void setPlayers(Player player1, Player player2, ComboBox<Property> properties1CB, ComboBox<Property> properties2CB){
        this.player1 = player1;
        this.player2 = player2;

        player1Buying.setText(player1.getName());
        player2Buying.setText(player2.getName());

        player1Selling.setText(player1.getName());
        player2Selling.setText(player2.getName());

        player1CB = properties1CB;
        player2CB = properties2CB;
    }
    @FXML
    private RadioButton player1Buying;

    @FXML
    private ToggleGroup players;

    @FXML
    private RadioButton player2Buying;

    @FXML
    private RadioButton player1Selling;

    @FXML
    private RadioButton player2Selling;

    @FXML
    private ComboBox<Property> citiesCB;

    @FXML
    private Button accept;

    @FXML
    private TextField offer;

    @FXML
    private Label buyingPlayer;

    @FXML
    private Label sellingPlayer;

    @FXML
    private Button reject;

    @FXML
    void acceptTrade(ActionEvent event) {

    }

    @FXML
    void radioCheck(ActionEvent event) {

        if(player1Buying.isSelected()){

            player1Selling.setVisible(false);
            player2Selling.setVisible(true);

            player2Selling.setSelected(true);
            buyingPlayer.setText(player1.getName());
            sellingPlayer.setText(player2.getName());

            List<Property> exchangeCities = new ArrayList<>();

            for (int i = 0; i < player2.getCities().size(); i++){
                exchangeCities.add(player2.getCities().get(i));
            }

            citiesCB = new ComboBox<>(FXCollections.observableArrayList(exchangeCities));
        }
        if(player2Buying.isSelected()){
            player2Selling.setVisible(false);
            player1Selling.setVisible(true);

            player1Selling.setSelected(true);

            buyingPlayer.setText(player2.getName());
            sellingPlayer.setText(player1.getName());

            List<Property> exchangeCities = new ArrayList<>();

            for (int i = 0; i < player1.getCities().size(); i++){
                exchangeCities.add(player1.getCities().get(i));
            }

            citiesCB = new ComboBox<>(FXCollections.observableArrayList(exchangeCities));
            System.out.println("dupa");
        }
    }

    @FXML
    void rejectTrade(ActionEvent event) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }
}