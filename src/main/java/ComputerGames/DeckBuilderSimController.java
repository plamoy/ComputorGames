package ComputerGames;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.ResourceBundle;

public class DeckBuilderSimController implements Initializable {

    private Hexagon[] tiles = new Hexagon[72];

    @FXML
    private BorderPane deckBuilderBorderPane;

    public void buildCenterPane() {
        int height = 550;
        int width = 800;
        AnchorPane tileMap = new AnchorPane();
        double size = 50;
        double v = Math.sqrt(3) / 2.0;
        int count = 0;
        for (double y = 0; y < height; y += size * Math.sqrt(3)) {
            for (double x = 0; x < width; x += (3.0 / 2.0) * size * 2) {
                double[] vertices = {x, y,
                        x + size, y,
                        x + size * (3.0 / 2.0), y + size * v,
                        x + size, y + size * Math.sqrt(3),
                        x, y + size * Math.sqrt(3),
                        x - (size / 2.0), y + size * v};
                Hexagon tile = new Hexagon(vertices);
                tile.setFill(Paint.valueOf("#ffffff"));
                tile.setStrokeWidth(2);
                tile.setStroke(Paint.valueOf("#000000"));
                tileMap.getChildren().add(tile);
                tiles[count] = tile;
                count++;
            }
        }
        for (double y = size * v; y < height; y += size * Math.sqrt(3)) {
            for (double x = size * (3.0 / 2.0); x < width; x += (3.0 / 2.0) * size * 2) {
                double[] vertices = {x, y,
                        x + size, y,
                        x + size * (3.0 / 2.0), y + size * v,
                        x + size, y + size * Math.sqrt(3),
                        x, y + size * Math.sqrt(3),
                        x - (size / 2.0), y + size * v};
                Hexagon tile = new Hexagon(vertices);
                tile.setFill(Paint.valueOf("#ffffff"));
                tile.setStrokeWidth(2);
                tile.setStroke(Paint.valueOf("#000000"));
                tileMap.getChildren().add(tile);
                tiles[count] = tile;
                count++;
            }
        }
        deckBuilderBorderPane.setCenter(tileMap);
        deckBuilderBorderPane.setPadding(new Insets(50));
        //deckBuilderBorderPane.getScene().getWindow().sizeToScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildCenterPane();
    }

}
