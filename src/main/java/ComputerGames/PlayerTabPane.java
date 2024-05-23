package ComputerGames;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;


public class PlayerTabPane extends AnchorPane { //track money

    public int startingLocation = 1;
    public int playerClass = 4;
    public boolean playerChosen = false;
    public Button setStartButton = new Button();

    PlayerTabPane(){
        buildPlayerTabPane();
    }

    public void buildPlayerTabPane() {
        Label healthLabel = new Label("Health");
        Label movementLabel = new Label("Movement");
        movementLabel.setLayoutY(50);
        Label equipmentSlotsLabel = new Label("Equipment Slots");
        equipmentSlotsLabel.setLayoutY(100);
        Label playerClassLabel = new Label("Class");
        playerClassLabel.setLayoutY(150);
        Label locationStartLabel = new Label("Starting Location");
        locationStartLabel.setLayoutY(200);

        Slider healthSlider = new Slider(0,10,5);
        healthSlider.setLayoutY(20);
        healthSlider.setShowTickLabels(true);
        healthSlider.setShowTickLabels(true);
        healthSlider.setMajorTickUnit(1);
        healthSlider.setBlockIncrement(1);

        Slider movementSlider = new Slider(1,6,3);
        movementSlider.setLayoutY(70);
        movementSlider.setShowTickLabels(true);
        movementSlider.setShowTickLabels(true);
        movementSlider.setMajorTickUnit(1);
        movementSlider.setBlockIncrement(1);

        Slider equipmentSlotsSlider = new Slider(1,4,1);
        equipmentSlotsSlider.setLayoutY(120);
        equipmentSlotsSlider.setShowTickLabels(true);
        equipmentSlotsSlider.setShowTickLabels(true);
        equipmentSlotsSlider.setMajorTickUnit(1);
        equipmentSlotsSlider.setBlockIncrement(1);

        ChoiceBox<String> classChoice = new ChoiceBox<>();
        classChoice.getItems().addAll("Agro", "Tank", "Support", "Balance");
        classChoice.setLayoutY(170);

        ChoiceBox<String> locationChoice = new ChoiceBox<>();
        locationChoice.getItems().addAll("Top Left", "Top Right", "Bottom Left", "Bottom Right");
        locationChoice.setLayoutY(220);

        setStartButton.setText("Set Start");
        setStartButton.setLayoutY(250);
        setStartButton.setOnAction(e -> {
            if (classChoice.getValue() != null && locationChoice.getValue() != null) {
                classChoice.setMouseTransparent(true);
                locationChoice.setMouseTransparent(true);
                playerChosen = true;
                if (Objects.equals(classChoice.getValue(), "Agro")) {
                    playerClass = 1;
                    healthSlider.setMax(8);
                    movementSlider.setMax(7);
                    healthSlider.setValue(4);
                    movementSlider.setValue(4);
                } else if (Objects.equals(classChoice.getValue(), "Tank")) {
                    playerClass = 2;
                    healthSlider.setMax(12);
                    movementSlider.setMax(5);
                    healthSlider.setValue(6);
                    movementSlider.setValue(2);
                } else if (Objects.equals(classChoice.getValue(), "Support")) {
                    playerClass = 3;
                } else if (Objects.equals(classChoice.getValue(), "Balance")) {
                    playerClass = 4;
                }
                if (Objects.equals(locationChoice.getValue(), "Top Left")) {
                    startingLocation = 1;
                } else if (Objects.equals(locationChoice.getValue(), "Top Right")) {
                    startingLocation = 2;
                } else if (Objects.equals(locationChoice.getValue(), "Bottom Left")) {
                    startingLocation = 3;
                } else if (Objects.equals(locationChoice.getValue(), "Bottom Right")) {
                    startingLocation = 4;
                }
            }
        });

        this.getChildren().addAll(healthLabel, movementLabel, equipmentSlotsLabel, playerClassLabel, locationStartLabel, healthSlider, movementSlider, equipmentSlotsSlider, classChoice, locationChoice, setStartButton);
    }

}
