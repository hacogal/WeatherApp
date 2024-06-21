// Haizan Cordoba Gallardo - ID: 200578172

package org.example.a1weatherdata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file for the main view
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set the title of the stage (main window)
        stage.setTitle("Toronto Weather Data");

        // Set the icon for the stage
        Image icon = new Image(WeatherApp.class.getResourceAsStream("/icon.png"));
        stage.getIcons().add(icon);

        // Set the scene for the stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
