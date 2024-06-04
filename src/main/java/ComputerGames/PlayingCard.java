package ComputerGames;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public Rectangle card = new Rectangle(200,200, Paint.valueOf("red"));
    //private ImageView cardBack = new ImageView(new Image(getClass().getResource()));

    public PlayingCard() {
        card.setStyle(" -fx-stroke: black; -fx-stroke-width: 5;");
        this.getChildren().add(card);
        this.setOnMouseClicked(this::clicked);
    }

    public void setCardColor(String cardColor) {
        card.setStyle("-fx-fill: " + cardColor + "; -fx-stroke: black; -fx-stroke-width: 5;");
    }

    public void setCardText(String text) {
        this.cardText = text;
    }

    private void clicked(MouseEvent event) {
        this.setCardColor("YELLOW");
    }

    /***
     * handle where cards move
     * adding to hand / drawing
     * adding to equipment / based on if slots open and available
     * adding to discard pile
     */
}
