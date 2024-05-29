package ComputerGames;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class PlayingCard extends Rectangle {

    public String cardName;
    public int damage;
    public int sellPrice;
    public int actions;
    public String cardText;
    public String cardColor = "red";

    public PlayingCard() {
        this.setWidth(100);
        this.setHeight(200);
        this.setStyle("-fx-fill: " + cardColor + "; -fx-stroke: black; -fx-stroke-width: 5;");
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
        this.setStyle("-fx-fill: " + cardColor + "; -fx-stroke: black; -fx-stroke-width: 5;");
    }
}
