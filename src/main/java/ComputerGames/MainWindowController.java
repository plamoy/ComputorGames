package ComputerGames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private BorderPane mainBoardBorderPane;

    @FXML
    void openMineSweeper(ActionEvent event) {
        MultiFXMLLoder loader = new MultiFXMLLoder();
        Pane gameArea = loader.getPane("minesweeper");
        mainBoardBorderPane.setCenter(gameArea);
    }

    @FXML
    void openPong(ActionEvent event) {
        MultiFXMLLoder loader = new MultiFXMLLoder();
        Pane gameArea = loader.getPane("pong");
        mainBoardBorderPane.setCenter(gameArea);
    }

    @FXML
    void openDeckBuilderSim(ActionEvent event) {
        MultiFXMLLoder loader = new MultiFXMLLoder();
        Pane gameArea = loader.getPane("deckBuilderBoard");
        mainBoardBorderPane.setCenter(gameArea);
    }

    @FXML
    void openSnake(ActionEvent event) {
        // load snake fxml and controller
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
