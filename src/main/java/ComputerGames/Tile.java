package ComputerGames;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Tile extends ImageView {

    Image tileImage;
    Image startImage;
    int neighboringBombs = 0;
    private boolean bomb;
    private boolean flagged, opened;

    public Tile(boolean bomb, boolean flagged, boolean opened, String tileImage) {
        this.bomb = bomb;
        this.flagged = flagged;
        this.opened = opened;
        this.startImage = new Image(tileImage);
        this.setImage(new Image(tileImage));
        this.setPickOnBounds(true);
    }

    public void updateImage(Image tileImage) {
        this.tileImage = tileImage;
        this.setImage(tileImage);
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void toggleFlag() {
        //update tile image to a flag or no flag
        flagged = !flagged;
        if (isFlagged()) {
            updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/flag-filled-35.png"))));
        } else {
            updateImage(startImage);
        }
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
        // show number or bomb
        // make non clickable
    }

    public void setNeighboringBombs(int neighboringBombs) {
        this.neighboringBombs = neighboringBombs;
    }

}
