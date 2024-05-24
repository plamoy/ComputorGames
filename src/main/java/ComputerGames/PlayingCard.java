package ComputerGames;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class PlayingCard extends Rectangle {

    public String cardName;
    public int damage;
    public int sellPrice;
    public int actions;
    public String cardText;

    public PlayingCard() {
        this.setWidth(100);
        this.setHeight(200);
        this.setFill(Paint.valueOf("GREEN"));
    }
}
