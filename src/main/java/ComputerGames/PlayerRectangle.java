package ComputerGames;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PlayerRectangle extends Rectangle {

    public Image rectangleImage;
    public int playerNumber;

    PlayerRectangle(){
        this.setWidth(25);
        this.setHeight(50);

        this.setOnMouseDragged(event -> dragged(event,this));


    }

    private void dragged(MouseEvent event, PlayerRectangle playerRectangle) {
        playerRectangle.setX(playerRectangle.getX() + event.getX());
        playerRectangle.setY(playerRectangle.getY() + event.getY());
        playerRectangle.setTranslateX(playerRectangle.getX());
        playerRectangle.setTranslateY(playerRectangle.getY());
        // figure out how to scale translations to size of board
    }

    public void setRectangleImage(String imagePath) {
        this.rectangleImage = new Image(imagePath);
        this.setFill(new ImagePattern(this.rectangleImage));
    }

    public void setPlayerNumber(int playerNumber){
       this.playerNumber = playerNumber;
    }

}
