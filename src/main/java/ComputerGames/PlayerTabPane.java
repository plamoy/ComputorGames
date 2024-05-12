package ComputerGames;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

public class PlayerTabPane extends AnchorPane {

    public int startingLocation = 1;
    public int playerClass = 1;
    public int playerHealth;
    public int playerMovement;

    PlayerTabPane(){
        buildPlayerTabPane();
    }

    public void buildPlayerTabPane() {
        Label healthLabel = new Label("Health");
        Label movementLabel = new Label("Movement");
        movementLabel.setLayoutY(50);
        Label equipmentSlotsLabel = new Label("Equipment Slots");
        equipmentSlotsLabel.setLayoutY(75);

        Slider healthSlider = new Slider(0,10,5);
        healthSlider.setLayoutY(25);

        this.getChildren().addAll(healthLabel,healthSlider, movementLabel, equipmentSlotsLabel);
    }

}
