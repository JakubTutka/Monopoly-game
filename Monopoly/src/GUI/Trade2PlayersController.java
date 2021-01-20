package GUI;

import Cells.Property;
import General.*;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane mainAnchorPane;

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
    private Label buyingPlayerTX;

    @FXML
    private Label sellingPlayerTX;

    @FXML
    private Button reject;

    Player buyingPlayer;
    Player sellingPlayer;

    @FXML
    void acceptTrade(ActionEvent event) {
        boolean isPriceInt = true;
        boolean isComboEmpty = false;

        try {
            Integer.parseInt(offer.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wprowadź poprwanie cene!");
            alert.show();
            isPriceInt = false;
        }

        if(citiesCB.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nie wybrano miasta!");
            alert.show();
            isComboEmpty = true;
        }

        if (isPriceInt && !isComboEmpty){
            int offerPrice = Integer.parseInt(offer.getText());

            sellingPlayer.plusMoney(offerPrice);
            buyingPlayer.minusMoney(offerPrice);

            buyingPlayer.getCities().add(citiesCB.getValue());
            sellingPlayer.getCities().remove(citiesCB.getValue());

            Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stageTheEventSourceNodeBelongs.close();
        }

    }

    @FXML
    void radioCheck(ActionEvent event) {

        if(player1Buying.isSelected()){

            buyingPlayer = player1;
            sellingPlayer = player2;

            player1Selling.setVisible(false);
            player2Selling.setVisible(true);

            player2Selling.setSelected(true);
            buyingPlayerTX.setText(buyingPlayer.getName());
            sellingPlayerTX.setText(sellingPlayer.getName());

            citiesCB.getItems().removeAll(citiesCB.getItems());

            for (int i = 0; i < sellingPlayer.getCities().size(); i++){
                citiesCB.getItems().add(sellingPlayer.getCities().get(i));
            }

        }
        if(player2Buying.isSelected()){

            buyingPlayer = player2;
            sellingPlayer = player1;

            player2Selling.setVisible(false);
            player1Selling.setVisible(true);

            player1Selling.setSelected(true);

            buyingPlayerTX.setText(buyingPlayer.getName());
            sellingPlayerTX.setText(sellingPlayer.getName());

            citiesCB.getItems().removeAll(citiesCB.getItems());

            for (int i = 0; i < sellingPlayer.getCities().size(); i++){
                citiesCB.getItems().add(sellingPlayer.getCities().get(i));
            }

        }
    }

    @FXML
    void rejectTrade(ActionEvent event) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }
}