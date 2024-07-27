package ComputerGames;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerHandTabPane extends AnchorPane {

    // button to shuffle deck
    // button to shuffle discard pile into deck
    public ArrayList<PlayingCard> playerDeck = new ArrayList<PlayingCard>();
    public ArrayList<PlayingCard> playerDiscardPile = new ArrayList<PlayingCard>();
    public StackPane playerDeckImage = new StackPane();
    private PlayingCard[] equipmentSlots = new PlayingCard[4];
    public StackPane playerDiscardPileImage = new StackPane();

    PlayerHandTabPane() throws IOException {
        HBox mainHBox = new HBox();

        //create starting deck and shuffle
        AnchorPane playerDeckPane = new AnchorPane();
        playerDeckImage.setPadding(new Insets(10));

        PlayingCard deckCard = new PlayingCard();
        deckCard.setCardColor("green");
        playerDeckImage.getChildren().add(deckCard);
        Button drawButton = new Button("Draw");
        drawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // take top of deck array pull from array and add to player hand
                // response if no cards in deck or change deck image or add card counter showing number in array
            }
        });

        VBox playerHandAndEquipmentVBox = new VBox();
        HBox playerHandHBox = new HBox();
        HBox playerEquipmentHBox = new HBox();
        Button discardHandButton = new Button("Discard Hand");
        discardHandButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // remove all children from playerHandHBox and add to discard pile array
            }
        });
        for (int i = 0; i < 4; i++) {
            equipmentSlots[i] = new PlayingCard();
        }
        playerEquipmentHBox.getChildren().addAll(equipmentSlots);

        AnchorPane playerDiscardPane = new AnchorPane();
        playerDiscardPileImage.setPadding(new Insets(10));
        PlayingCard discardCard = new PlayingCard();
        discardCard.setCardColor("blue");
        playerDiscardPileImage.getChildren().add(discardCard);
        // add shuffle discard pile and add to bottom of deck

        playerDeckPane.getChildren().add(playerDeckImage);
        playerHandAndEquipmentVBox.getChildren().addAll(playerEquipmentHBox, playerHandHBox);
        playerDiscardPane.getChildren().add(playerDiscardPileImage);
        mainHBox.getChildren().addAll(playerDeckPane, playerHandAndEquipmentVBox, playerDiscardPane);
        this.getChildren().add(mainHBox);
    }
}
