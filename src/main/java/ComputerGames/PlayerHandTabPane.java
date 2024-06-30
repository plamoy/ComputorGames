package ComputerGames;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerHandTabPane extends AnchorPane {

    // button to shuffle deck
    // button to shuffle discard pile into deck

    public StackPane playerDeck = new StackPane();
    private PlayingCard[] equipmentSlots = new PlayingCard[4];
    public StackPane playerDiscardPile = new StackPane();

    PlayerHandTabPane() {
        HBox mainHBox = new HBox();
        AnchorPane playerDeckPane = new AnchorPane();
        VBox playerHandAndEquipmentVBox = new VBox();
        HBox playerEquipmentHBox = new HBox();
        HBox playerHandHBox = new HBox();
        AnchorPane playerDiscardPane = new AnchorPane();

        playerDeck.setPadding(new Insets(10));
        PlayingCard deckCard = new PlayingCard();
        deckCard.setCardColor("green");
        playerDeck.getChildren().add(deckCard);

        for (int i = 0; i < 4; i++) {
            equipmentSlots[i] = new PlayingCard();
        }

        playerEquipmentHBox.getChildren().addAll(equipmentSlots);

        playerDiscardPile.setPadding(new Insets(10));
        PlayingCard discardCard = new PlayingCard();
        discardCard.setCardColor("blue");
        playerDiscardPile.getChildren().add(discardCard);

        playerDeckPane.getChildren().add(playerDeck);
        playerHandAndEquipmentVBox.getChildren().addAll(playerEquipmentHBox, playerHandHBox);
        playerDiscardPane.getChildren().add(playerDiscardPile);
        mainHBox.getChildren().addAll(playerDeckPane, playerHandAndEquipmentVBox, playerDiscardPane);
        this.getChildren().add(mainHBox);
    }

}
