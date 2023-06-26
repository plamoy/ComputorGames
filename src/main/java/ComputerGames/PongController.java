package ComputerGames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class PongController implements Initializable {

    private PongBoard pongCanvas;

    @FXML
    private Button singlePlayerButton;
    @FXML
    private Button twoPlayerButton;
    @FXML
    private BorderPane pongBorderPane;

    @FXML
    void singlePlayerButtonClicked(ActionEvent event) {
        pongBorderPane.setCenter(new PongBoard(1));
        turnOffButtons();
    }

    @FXML
    void twoPlayerButtonClicked(ActionEvent event) {
        pongBorderPane.setCenter(new PongBoard(2));
        turnOffButtons();
    }

    private void turnOffButtons() {
        singlePlayerButton.setMouseTransparent(true);
        twoPlayerButton.setMouseTransparent(true);
    }


    @FXML
    void pongKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            pongCanvas.playerOneYPos++;
        } else if (event.getCode() == KeyCode.DOWN) {
            pongCanvas.playerOneYPos--;
        }
    }

    @FXML
    void pongKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            pongCanvas.gameStarted = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
