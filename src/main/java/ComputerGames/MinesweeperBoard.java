package ComputerGames;


import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class MinesweeperBoard extends GridPane {

    int columns;
    int rows;
    int bombs;
    Tile[][] playTiles;

    public MinesweeperBoard (int columns, int rows, int bombs) {
        this.columns = columns;
        this.rows = rows;
        this.bombs = bombs;
        this.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: blue;");
        playTiles = buildTiles(rows, columns, bombs);
        setTiles();
    }

    public void setTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                super.add(playTiles[i][j], j, i);
            }
        }
    }

    public Tile[][] buildTiles(int numRows, int numColumns, int numBombs) {
        // build array of Tile tiles
        Tile[][] playTiles = new Tile[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            int check = 1;
            for (int j = 0; j < numColumns; j++) {
                if (i % 2 == 0) {
                    if (check == 1) {
                        playTiles[i][j] = new Tile(false, false, false, String.valueOf(getClass().getResource("/minesweeperImages/new-tile1-35.png")));
                        check = 0;
                    } else {
                        playTiles[i][j] = new Tile(false, false, false, String.valueOf(getClass().getResource("/minesweeperImages/new-tile2-35.png")));
                        check = 1;
                    }
                } else {
                    if (check == 1) {
                        playTiles[i][j] = new Tile(false, false, false, String.valueOf(getClass().getResource("/minesweeperImages/new-tile2-35.png")));
                        check = 0;
                    } else {
                        playTiles[i][j] = new Tile(false, false, false, String.valueOf(getClass().getResource("/minesweeperImages/new-tile1-35.png")));
                        check = 1;
                    }
                }
            }
        }
        // set bombs based on random locations
        for (int i = 0; i < numBombs; i++) {
            int randomColumn = genRandom(numColumns);
            int randomRow = genRandom(numRows);
            if (playTiles[randomRow][randomColumn].isBomb()) {
                i--;
            } else {
                playTiles[randomRow][randomColumn].setBomb(true);
            }
        }
        // set neighboringbombs amounts for each Tile tile
        //      | [row-1][col-1] | [row-1][col] | [row-1][col+1] |
        //      | [row][col-1]   | current Tile | [row][col+1]   |
        //      | [row+1][col-1] | [row+1][col] | [row+1][col+1] |
        // remove rows or columns from the neighbors array to match the current Tiles position on the board
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                int[][] neighbors = new int[][]{{row-1,col-1},{row-1, col},{row-1, col+1},{row, col-1},{row, col+1},{row+1,col-1},{row+1,col},{row+1,col+1}};
                if (row - 1 < 0 ) {
                    // take out top row
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 2; j++) {
                            neighbors[i][j] = 10000;
                        }
                    }
                }
                if (row + 1 == numRows) {
                    // take out bottom row
                    for (int i = 5; i < 8; i++) {
                        for (int j = 0; j < 2; j++) {
                            neighbors[i][j] = 10000;
                        }
                    }
                }
                if (col - 1 < 0) {
                    // take out left col
                    int[] leftCol = new int[]{0,3,5};
                    for (int i : leftCol) {
                        for (int j = 0; j < 2; j++) {
                            neighbors[i][j] = 10000;
                        }
                    }
                }
                if (col + 1 == numColumns) {
                    // take out right col
                    int[] rightCol = new int[]{2,4,7};
                    for (int i : rightCol) {
                        for (int j = 0; j < 2; j++) {
                            neighbors[i][j] = 10000;
                        }
                    }
                }
                int bombCount = 0;
                for (int[] i : neighbors) {
                    if (i[0] != 10000) {
                        if (playTiles[i[0]][i[1]].isBomb()) {
                            bombCount++;
                        }
                    }
                }
                if (bombCount != 0) {
                    playTiles[row][col].setNeighboringBombs(bombCount);
                }
            }
        }
        return playTiles;
    }

    public int genRandom(int boundary) {
        return (int) Math.floor(Math.random()*(boundary));
    }

    public void showNumber(Tile tile) {
        switch (tile.neighboringBombs) {
            case 1 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number1-35.png"))));
            case 2 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number2-35.png"))));
            case 3 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number3-35.png"))));
            case 4 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number4-35.png"))));
            case 5 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number5-35.png"))));
            case 6 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number6-35.png"))));
            case 7 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number7-35.png"))));
            case 8 -> tile.updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/number8-35.png"))));
        }
    }

    public void revealNeighborBlanks(int row, int col) {
        int[][] neighborIndex = new int[][]{{row-1,col-1},{row-1, col},{row-1, col+1},{row, col-1},{row, col+1},{row+1,col-1},{row+1,col},{row+1,col+1}};
        for (int[] i : neighborIndex) {
            if (i[0] >= 0 && i[0] < rows && i[1] >= 0 && i[1] < columns && !playTiles[i[0]][i[1]].isOpened()) {
                playTiles[i[0]][i[1]].setOpened(true);
                if (playTiles[i[0]][i[1]].neighboringBombs == 0) {
                    playTiles[i[0]][i[1]].updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/blank-tile-35.png"))));
                    revealNeighborBlanks(i[0], i[1]);
                } else {
                    showNumber(playTiles[i[0]][i[1]]);
                }
            }
        }
    }

    public void showOtherBombs() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (playTiles[i][j].isBomb() && !playTiles[i][j].isOpened()) {
                    playTiles[i][j].updateImage(new Image(String.valueOf(getClass().getResource("/minesweeperImages/naval-mine-35.png"))));
                }
            }
        }
    }
}
