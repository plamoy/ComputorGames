package ComputerGames;

import javafx.event.EventHandler;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class Hexagon extends Polygon {

    public double[] vertices; // double array of all the vertices coordinates for the hexagon [x1, y1, x2, y2....xN, yN]
    public int encounterChance = 1;
    /***
     * the encounter chance is the value of an enemy attacking and forcing combat
     * 1 = 0% chance of encounter
     * 2 = 25% chance of encounter
     * 3 = 50% chance of encounter
     * 4 = 75% chance of encounter
     */

    public int specialTile = 1;
    /***
     * the special tile denotes if a tile is a "special" location
     * 1 = nothing
     * 2 = town
     * 3 = loot spot
     * 4 = enemy location
     * 5 = boss location
     */
    public boolean faceUp = false; //denotes if the tile is revealed or not


    Hexagon(double[] vertices){
        this.vertices = vertices;
        Double[] coordinateValue = new Double[12];
        for (int i = 0; i < vertices.length; i++){
            coordinateValue[i] = vertices[i];
        }
        this.getPoints().addAll(coordinateValue);
        addEventHandling();
    }

    Hexagon(double[] vertices, int encounterChance, int specialTile){
        this.vertices = vertices;
        Double[] coordinateValue = new Double[12];
        for (int i = 0; i < vertices.length; i++){
            coordinateValue[i] = vertices[i];
        }
        this.getPoints().addAll(coordinateValue);
        this.encounterChance = encounterChance;
        this.specialTile = specialTile;
        addEventHandling();
    }

    private void addEventHandling() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!faceUp) {
                    setEffect(new InnerShadow(BlurType.GAUSSIAN, Color.BLUE, 20,0,0,0));
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!faceUp) {
                    setFill(Paint.valueOf("#ffffff"));
                    setEffect(null);
                }
            }
        });
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!faceUp) {
                    setFill(Paint.valueOf("ff1100"));
                    faceUp = true;
                } else {
                    setFill(Paint.valueOf("#ffffff"));
                }
            }
        });
    }

    public void setVertices(double[] vertices) {
        this.vertices = vertices;
    }

    public void setEncounterChance(int encounterChance) {
        this.encounterChance = encounterChance;
    }

    public int getEncounterChance() {
        return encounterChance;
    }

    public void setSpecialTile(int specialTile) {
        this.specialTile = specialTile;
    }
     public int getSpecialTile() {
        return specialTile;
     }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public String getHexNumber(){ return String.valueOf(this.encounterChance);}
}
