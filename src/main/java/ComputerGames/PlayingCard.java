package ComputerGames;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Objects;

public class PlayingCard extends StackPane {

    public String cardName;
    public int damage;
    public int sellPrice;
    public int actions;
    public String cardText;
    public boolean faceUp = false;
    public Rectangle card = new Rectangle(200,200, Paint.valueOf("red"));
    private ImageView cardBack = new ImageView(new Image(Objects.requireNonNull(getClass().getResource("/deckBuilderImages/CardBack.png")).openStream()));

    public PlayingCard() throws IOException {
        card.setStyle(" -fx-stroke: black; -fx-stroke-width: 5;");
        this.getChildren().add(cardBack);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    if (event.getClickCount() == 1) {
                        clicked();
                    } else if (event.getClickCount() > 1) {
                        doubleClicked();
                    }
                }
            }
        });
    }

    public void setCardColor(String cardColor) {
        card.setStyle("-fx-fill: " + cardColor + "; -fx-stroke: black; -fx-stroke-width: 5;");
    }

    public void setCardText(String text) {
        this.cardText = text;
    }

    private void clicked() {
        this.setCardColor("YELLOW");

    }

    private void doubleClicked() {
        this.setCardColor("CYAN");
    }

    /***
     * handle where cards move
     * adding to hand / drawing
     * adding to equipment / based on if slots open and available
     * adding to discard pile
     */
}
