package ComputerGames;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PlayerHandTabPane extends AnchorPane {

    // horizontal box with vertical boxs to make grids for hands deck and discard // equipped
    // button to draw card? maybe

    PlayerHandTabPane(){buildPlayerHandTabPane();}

    public void buildPlayerHandTabPane() {
        HBox mainHBox = new HBox();
        AnchorPane playerDeckPane = new AnchorPane();
        VBox playerHandAndEquipmentVBox = new VBox();
        HBox playerEquipmentHBox = new HBox();
        HBox playerHandHBox = new HBox();
        AnchorPane playerDiscardPane = new AnchorPane();

        StackPane deck = new StackPane();
        deck.setPadding(new Insets(10));
        deck.getChildren().add(new PlayingCard());

        playerDeckPane.getChildren().add(deck);
        playerHandAndEquipmentVBox.getChildren().addAll(playerEquipmentHBox,playerHandHBox);
        mainHBox.getChildren().addAll(playerDeckPane,playerHandAndEquipmentVBox,playerDiscardPane);
    }

}
