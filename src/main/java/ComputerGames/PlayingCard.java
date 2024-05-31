package ComputerGames;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class PlayingCard extends StackPane {

    public String cardName;
    public int damage;
    public int sellPrice;
    public int actions;
    public String cardText;
    public boolean faceUp = false;
    public Rectangle playingCard = new Rectangle(100,200, Paint.valueOf("red"));

    public PlayingCard() {
        this.setWidth(100);
        this.setHeight(200);
        playingCard.setStyle(" -fx-stroke: black; -fx-stroke-width: 5;");
        this.getChildren().add(playingCard);
        this.setOnMouseClicked(this::clicked);
    }

    public void setCardColor(String cardColor) {
        playingCard.setStyle("-fx-fill: " + cardColor + "; -fx-stroke: black; -fx-stroke-width: 5;");
    }

    private void clicked(MouseEvent event) {

    }

    /***
     * handle where cards move
     * adding to hand / drawing
     * adding to equipment / based on if slots open and available
     * adding to discard pile
     */
}
