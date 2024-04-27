package ComputerGames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        pongBorderPane.setCenter(pongCanvas = new PongBoard(1));
        turnOffButtons();
        pongCanvas.setFocusTraversable(true);
        pongBorderPane.getScene().getWindow().sizeToScene();
    }

    @FXML
    void twoPlayerButtonClicked(ActionEvent event) {
        pongBorderPane.setCenter(pongCanvas = new PongBoard(2));
        turnOffButtons();
        pongCanvas.setFocusTraversable(true);
    }

    private void turnOffButtons() {
        singlePlayerButton.setMouseTransparent(true);
        singlePlayerButton.setVisible(false);
        singlePlayerButton.setManaged(false);
        twoPlayerButton.setMouseTransparent(true);
        twoPlayerButton.setVisible(false);
        twoPlayerButton.setManaged(false);
    }


    @FXML
    void pongKeyPressed(KeyEvent event) {
        System.out.println("key press registered");
        if (event.getCode() == KeyCode.UP) {
            pongCanvas.playerOneYPos-= 8;
        } else if (event.getCode() == KeyCode.DOWN) {
            pongCanvas.playerOneYPos+= 8;
        }
    }

    @FXML
    void pongKeyReleased(KeyEvent event) {
        System.out.println("key release registered");
        if (event.getCode() == KeyCode.SPACE) {
            pongCanvas.gameStarted = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
