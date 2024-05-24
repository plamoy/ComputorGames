package ComputerGames;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PlayerHandTabPane extends AnchorPane {

    // horizontal box with vertical boxs to make grids for hands deck and discard // equipped
    // button to draw card? maybe

    PlayerHandTabPane() {
        HBox mainHBox = new HBox();
        AnchorPane playerDeckPane = new AnchorPane();
        VBox playerHandAndEquipmentVBox = new VBox();
        HBox playerEquipmentHBox = new HBox();
        HBox playerHandHBox = new HBox();
        AnchorPane playerDiscardPane = new AnchorPane();

        StackPane deck = new StackPane();
        deck.setPadding(new Insets(10));
        PlayingCard testCard = new PlayingCard();
        deck.getChildren().add(testCard);


        playerDeckPane.getChildren().add(deck);
        playerHandAndEquipmentVBox.getChildren().addAll(playerEquipmentHBox, playerHandHBox);
        mainHBox.getChildren().addAll(playerDeckPane, playerHandAndEquipmentVBox, playerDiscardPane);
        this.getChildren().add(mainHBox);
    }

}
