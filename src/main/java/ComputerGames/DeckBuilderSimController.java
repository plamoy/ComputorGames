package ComputerGames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckBuilderSimController implements Initializable {

    private Hexagon[] tiles = new Hexagon[72];
    private PlayerTabPane[] playerTabPanes = new PlayerTabPane[4];
    private PlayerHandTabPane[] playerHandTabPanes = new PlayerHandTabPane[4];
    private PlayerRectangle[] playerRectangles = new PlayerRectangle[4];
    private final String[] stickFigurePaths = {"/deckBuilderImages/Black_StickFigure.png","/deckBuilderImages/Blue_StickFigure.png","/deckBuilderImages/Pink_StickFigure.png","/deckBuilderImages/Red_StickFigure.png"};
    private AnchorPane hexMap = new AnchorPane();
    private double hexSize = 50;
    @FXML
    private AnchorPane deckBuilderAnchorPane;
    @FXML
    private BorderPane deckBuilderBorderPane;

    @FXML
    void newGameButtonAction(ActionEvent event) {
        buildPlayerTabs();
        buildPlayerHands();
        buildCenterPane();
        deckBuilderAnchorPane.getScene().getWindow().sizeToScene();
        Rectangle2D primaryScreeBounds = Screen.getPrimary().getVisualBounds();
        deckBuilderBorderPane.getScene().getWindow().setX((primaryScreeBounds.getWidth() - deckBuilderBorderPane.getScene().getWindow().getWidth())/2);
        deckBuilderBorderPane.getScene().getWindow().setY((primaryScreeBounds.getHeight() - deckBuilderBorderPane.getScene().getWindow().getHeight())/2);
    }

    @FXML
    void beginButtonOnAction(ActionEvent event) {
        // shuffle market cards, loot cards, player decks
        // deal players chosen
        // set up board of players and flip adjacent tiles
            // player character rectangles and way to detect what tile at or system to move
        for (int i = 0; i < 4; i++) {
            if (playerTabPanes[i].playerChosen) {
                playerRectangles[i] = new PlayerRectangle();
                playerRectangles[i].setPlayerNumber(i);
                playerRectangles[i].setRectangleImage(String.valueOf((getClass().getResource(stickFigurePaths[i]))));
                hexMap.getChildren().add(playerRectangles[i]);
                playerRectangles[i].setX(i*10);
            }
        }
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
        playerTabPanes[0] = playerOnePane;
        playerTwoTab.setContent(playerTwoPane);
        playerTabPanes[1] = playerTwoPane;
        playerThreeTab.setContent(playerThreePane);
        playerTabPanes[2] = playerThreePane;
        playerFourTab.setContent(playerFourPane );
        playerTabPanes[3] = playerFourPane;

        tabs.getTabs().addAll(playerOneTab,playerTwoTab,playerThreeTab,playerFourTab);
        deckBuilderBorderPane.setLeft(tabs);
    }

    public void buildPlayerHands() {
        TabPane handTabs = new TabPane();
        Tab playerOneHandTab = new Tab();
        playerOneHandTab.setText("Player 1");
        PlayerHandTabPane playerOneHandPane = new PlayerHandTabPane();
        Tab playerTwoTab = new Tab();
        playerTwoTab.setText("Player 2");
        PlayerHandTabPane playerTwoPane = new PlayerHandTabPane();
        Tab playerThreeTab = new Tab();
        playerThreeTab.setText("Player 3");
        PlayerHandTabPane playerThreePane = new PlayerHandTabPane();
        Tab playerFourTab = new Tab();
        playerFourTab.setText("Player 4");
        PlayerHandTabPane playerFourPane = new PlayerHandTabPane();

        playerOneHandTab.setContent(playerOneHandPane);
        playerHandTabPanes[0] = playerOneHandPane;
        playerTwoTab.setContent(playerTwoPane);
        playerHandTabPanes[1] = playerTwoPane;
        playerThreeTab.setContent(playerThreePane);
        playerHandTabPanes[2] = playerThreePane;
        playerFourTab.setContent(playerFourPane);
        playerHandTabPanes[3] = playerFourPane;

        handTabs.getTabs().addAll(playerOneHandTab,playerTwoTab,playerThreeTab,playerFourTab);
        handTabs.setPrefHeight(300);
        deckBuilderBorderPane.setBottom(handTabs);
    }

    public void buildCenterPane() {
        double v = Math.sqrt(3) / 2.0;
        double column = 0;
        int columnRows = 7;
        for (int y = 0; y < 9; y ++) { //columns
            int count = 0;
            for (int x = 0; x < columnRows; x ++) { //rows
                double[] vertices = {0, 0,
                        hexSize, 0,
                        hexSize * (3.0 / 2.0), hexSize * v,
                        hexSize, hexSize * Math.sqrt(3),
                        0, hexSize * Math.sqrt(3),
                        0 - (hexSize / 2.0), hexSize * v};
                Hexagon tile = new Hexagon(vertices);
                StackPane stack = new StackPane();
                Text hexText = new Text(y +","+ x);
                tile.setFill(Paint.valueOf("#ffffff"));
                tile.setStrokeWidth(2);
                tile.setStroke(Paint.valueOf("#000000"));
                stack.getChildren().addAll(tile, hexText);
                stack.setLayoutX(column);
                if (y % 2 == 0) {
                    stack.setLayoutY(count*hexSize*Math.sqrt(3));
                } else {
                    stack.setLayoutY(count*hexSize*Math.sqrt(3)+(hexSize*Math.sqrt(3)*0.5));
                }
                hexMap.getChildren().add(stack);
                tiles[count] = tile;
                count++;
            }
            column = column + hexSize*(3.0/2.0);
            if (columnRows == 7) {
                columnRows = 6;
            } else {
                columnRows = 7;
            }
        }
        deckBuilderBorderPane.setCenter(hexMap);
        //deckBuilderBorderPane.getScene().getWindow().sizeToScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
