package ComputerGames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckBuilderSimController implements Initializable {

    private Hexagon[] tiles = new Hexagon[72];


    @FXML
    private AnchorPane bottomAnchorPane;
    @FXML
    private BorderPane deckBuilderBorderPane;
    @FXML
    private AnchorPane leftAnchorPane;
    @FXML
    private AnchorPane rightAnchorPane;

    @FXML
    void fourPlayerButtonAction(ActionEvent event) {
        buildPlayerTabs();
        buildCenterPane();
    }

    @FXML
    void resetButtonAction(ActionEvent event) {

    }

    public void buildPlayerTabs() {
        TabPane tabs = new TabPane();
        Tab playerOneTab = new Tab();
        playerOneTab.setText("Player 1");
        PlayerTabPane playerOnePane = new PlayerTabPane();
        Tab playerTwoTab = new Tab();
        playerTwoTab.setText("Player 2");
        PlayerTabPane playerTwoPane = new PlayerTabPane();
        Tab playerThreeTab = new Tab();
        playerThreeTab.setText("Player 3");
        PlayerTabPane playerThreePane = new PlayerTabPane();
        Tab playerFourTab = new Tab();
        playerFourTab.setText("Player 4");
        PlayerTabPane playerFourPane = new PlayerTabPane();

        playerOneTab.setContent(playerOnePane);
        playerTwoTab.setContent(playerTwoPane);
        playerThreeTab.setContent(playerThreePane);
        playerFourTab.setContent(playerFourPane );

        tabs.getTabs().addAll(playerOneTab,playerTwoTab,playerThreeTab,playerFourTab);
        deckBuilderBorderPane.setLeft(tabs);
    }

    public void buildCenterPane() {
        AnchorPane tileMap = new AnchorPane();
        double size = 50;
        double v = Math.sqrt(3) / 2.0;
        double column = 0;
        int columnRows = 7;
        for (int y = 0; y < 9; y ++) { //columns
            int count = 0;
            for (int x = 0; x < columnRows; x ++) { //rows
                double[] vertices = {0, 0,
                        size, 0,
                        size * (3.0 / 2.0), size * v,
                        size, size * Math.sqrt(3),
                        0, size * Math.sqrt(3),
                        0 - (size / 2.0), size * v};
                Hexagon tile = new Hexagon(vertices);
                StackPane stack = new StackPane();
                Text hexText = new Text(y +","+ x);
                tile.setFill(Paint.valueOf("#ffffff"));
                tile.setStrokeWidth(2);
                tile.setStroke(Paint.valueOf("#000000"));
                stack.getChildren().addAll(tile, hexText);
                stack.setLayoutX(column);
                if (y % 2 == 0) {
                    stack.setLayoutY(count*size*Math.sqrt(3));
                } else {
                    stack.setLayoutY(count*size*Math.sqrt(3)+(size*Math.sqrt(3)*0.5));
                }
                tileMap.getChildren().add(stack);
                tiles[count] = tile;
                count++;
            }
            column = column + size*(3.0/2.0);
            if (columnRows == 7) {
                columnRows = 6;
            } else {
                columnRows = 7;
            }
        }
        deckBuilderBorderPane.setCenter(tileMap);
        deckBuilderBorderPane.getScene().getWindow().sizeToScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
