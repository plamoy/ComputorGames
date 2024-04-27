module com.example.computorgames {
    requires javafx.controls;
    requires javafx.fxml;


    opens ComputerGames to javafx.fxml;
    exports ComputerGames;
}