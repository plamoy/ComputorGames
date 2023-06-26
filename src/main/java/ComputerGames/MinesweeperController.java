package ComputerGames;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MinesweeperController implements Initializable {

    private final SimpleTimer st = new SimpleTimer();
    private MinesweeperBoard playBoard;


    @FXML
    private BorderPane minesweeperBorderPane;
    @FXML
    private Label timerLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void buildEasyGame(ActionEvent event) {
        int numRows = 10;
        int numColumns = 20;
        int numBombs = 20;
        buildGameBoard(numRows, numColumns, numBombs);
        startTimer();
    }

    @FXML
    void buildMediumGame(ActionEvent event) {
        int numRows = 20;
        int numColumns = 30;
        int numBombs = 80;
        buildGameBoard(numRows, numColumns, numBombs);
        startTimer();
    }

    @FXML
    void buildHardGame(ActionEvent event) {
        int numRows = 25;
        int numColumns = 35;
        int numBombs = 150;
        buildGameBoard(numRows, numColumns, numBombs);
        startTimer();
    }

    @FXML
    void handleBorderPaneClicked(MouseEvent event) {
        Node clickedNode = (Node) event.getTarget();
        int colIndex = toIndex(GridPane.getColumnIndex(clickedNode));
        int rowIndex = toIndex(GridPane.getRowIndex(clickedNode));
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (!playBoard.playTiles[rowIndex][colIndex].isOpened()) {
                playBoard.playTiles[rowIndex][colIndex].setOpened(true);
                if (playBoard.playTiles[rowIndex][colIndex].isBomb()) {
                    playBoard.playTiles[rowIndex][colIndex].updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/explosion-35.png"))));
                    playBoard.showOtherBombs();
                    gameLost();
                } else {
                    if (playBoard.playTiles[rowIndex][colIndex].neighboringBombs == 0) {
                        playBoard.playTiles[rowIndex][colIndex].updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/blank-tile-35.png"))));
                        playBoard.revealNeighborBlanks(rowIndex, colIndex);
                        checkGameState();
                    } else {
                        playBoard.showNumber(playBoard.playTiles[rowIndex][colIndex]);
                        checkGameState();
                    }
                }
            }
        } else if (event.getButton().equals(MouseButton.SECONDARY)) {
            if (!playBoard.playTiles[rowIndex][colIndex].isOpened()) {
                playBoard.playTiles[rowIndex][colIndex].toggleFlag();
                checkGameState();
            }
        }
    }

    private int toIndex(Integer value) {
        return value == null ? 0 : value;
    }

    // Used to build the units to be used in the game based on the number of Rows, Columns, and Bombs
    public void buildGameBoard(int numRows, int numColumns, int numBombs){
        playBoard = new MinesweeperBoard(numColumns, numRows, numBombs);
        minesweeperBorderPane.setCenter(playBoard);
        BorderPane.setMargin(playBoard, new Insets(10.0,0.0,0.0,0.0));
        minesweeperBorderPane.getScene().getWindow().sizeToScene();
    }


    private void startTimer() {
        st.start();
        timerLabel.textProperty().bind(st.tTime.textProperty());
    }

    private void resetTimer() {
        st.clear();
        timerLabel.textProperty().bind(st.tTime.textProperty());
    }


    public void checkGameState() {
        int bombCheck = 0;
        int openCheck = 0;
        for (int i = 0; i < playBoard.rows; i++) {
            for (int j = 0; j < playBoard.columns; j++) {
                if (playBoard.playTiles[i][j].isFlagged() && playBoard.playTiles[i][j].isBomb()) {
                    bombCheck++;
                }
                if (playBoard.playTiles[i][j].isOpened()) {
                    openCheck++;
                }
            }
        }
        if (bombCheck == playBoard.bombs && openCheck == (playBoard.columns*playBoard.rows) - playBoard.bombs) {
            gameStateChanged();
            endMinesweeper.display("You're a Winner!" + st.tTime);
            resetTimer();
        }
    }

    public void gameStateChanged() {
        for (int i = 0; i < playBoard.rows; i++) {
            for (int j = 0; j < playBoard.columns; j++) {
                playBoard.playTiles[i][j].setMouseTransparent(true);
                minesweeperBorderPane.setMouseTransparent(true);
            }
        }
        st.pause();
    }

    public void gameLost() {
        gameStateChanged();
        endMinesweeper.display("You're a LOSER!" + st.tTime);
        resetTimer();
    }

    private class endMinesweeper {
        public static void display(String text) {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Label label = new Label(text);
            VBox layout = new VBox(label);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 200, 100);
            stage.setTitle("Dialog");
            stage.setScene(scene);
            stage.show();
        }
    }


}
