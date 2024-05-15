package ComputerGames;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class MultiFXMLLoader {

    private Pane view;

    public Pane getPane(String fxmlfile) {
        try {
            URL fileUrl = ComputerGamesApp.class.getResource("/GameFXMLs/" + fxmlfile + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("No page " + fxmlfile + " please check FXMLLoader");
        }
        return view;
    }

}
