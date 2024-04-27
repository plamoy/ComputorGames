package ComputerGames;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SimpleTimer {

    public Text tTime;
    private int hours;
    private int minutes;
    private int seconds;
    private Timeline timeline;

    public SimpleTimer() {
        hours = 0;
        minutes = 0;
        seconds = 0;

        // set up the time display
        tTime = new Text();
        tTime.setFont(Font.font("SansSerif", 50));
        setTime();
    }


    public void start() {
        KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> {
            seconds++;
            setTime();
        });

        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void pause() {
        timeline.pause();
    }

    public void resume() {
        timeline.play();
    }

    public void clear() {
        timeline.stop();
        hours = 0;
        minutes = 0;
        seconds = 0;
        setTime();
    }

    public void setTime() {
        // flip 60 seconds over to a minute
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        // flip 60 minutes over to an hour
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        // ensure that values < 10 are padded with a 0
        String h = hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours);
        String m = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
        String s = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

        tTime.setText(h + ":" + m + ":" + s);
    }

}
