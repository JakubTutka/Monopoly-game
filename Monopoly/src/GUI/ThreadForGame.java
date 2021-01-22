package GUI;

import General.Player;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ThreadForGame extends Thread{
    Player player1;
    Player player2;
    Stage stage;

    public ThreadForGame(Player player1, Player player2, Stage stage){
        this.player1 = player1;
        this.player2 = player2;
        this.stage = this.stage;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(3000);
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

}
