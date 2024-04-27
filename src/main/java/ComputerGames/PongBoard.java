package ComputerGames;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.util.Random;

public class PongBoard extends Canvas {

    private static final int width = 800;
    private static final int height = 600;
    private static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_WIDTH = 15;
    private static final double BALL_R = 15;
    private double ballYSpeed = 1;
    private double ballXSpeed = 1;
    public double playerOneYPos = height/2;
    public double playerTwoYPos = height/2;
    public int playerOneXPos = 0;
    public int playerTwoXPos = width-PLAYER_WIDTH;
    private double ballXPos = width/2;
    private double ballYPos = height/2;
    public GraphicsContext gc;
    public Timeline tl;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    public boolean gameStarted;

    public PongBoard(int numPlayers) {
        this.setHeight(height);
        this.setWidth(width);
        gc = this.getGraphicsContext2D();
        if (numPlayers == 1) {
            tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run1(gc)));
        } else {
            tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run2(gc)));
        }
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }

    private void run1(GraphicsContext gc) {
        gc.setFill(Color.NAVY);
        gc.fillRect(0,0, width, height);
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if (gameStarted) {
            // move ball based on its speed
            ballXPos+=ballXSpeed;
            ballYPos+=ballYSpeed;

            // computer brain
            if (ballXPos < width - width/5 ) {
                    playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
            } else {
                    playerTwoYPos = ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ? playerTwoYPos += 2 : playerTwoYPos - 2;
            }

            // draw the ball in the new position
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);

        } else {
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("On Space Bar", width / 2, height / 2);

            ballXPos = width / 2;
            ballYPos = height / 2;

            ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
            ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
        }

        if (ballYPos > (height-BALL_R)  || ballYPos < 0) ballYSpeed *= -1;

        //if you miss the ball, computer gets a point
        if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
            scoreP2++;
            gameStarted = false;
        }

        //if the computer misses the ball, you get a point
        if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {
            scoreP1++;
            gameStarted = false;
        }

        //increase the speed after the ball hits the player
        if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) ||
                ((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
            ballYSpeed += 0.8 * Math.signum(ballYSpeed);
            ballXSpeed += 0.8 * Math.signum(ballXSpeed);
            // this is where the trajectory math will have to happen
            ballXSpeed *= -1;
        }

        //draw score
        gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
        //draw player 1 & 2
        gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
    }

    private void run2(GraphicsContext gc) {
    }



}
