package org.example.a1weatherdata;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableViewController {

    // FXML annotations to link to the UI components defined in the FXML file
    @FXML
    private TableView<TorontoWeatherData> tableView; // TableView to display weather data

    @FXML
    private TableColumn<TorontoWeatherData, String> dateColumn; // TableColumn for the date

    @FXML
    private TableColumn<TorontoWeatherData, Double> temperatureColumn; // TableColumn for the temperature

    @FXML
    private TableColumn<TorontoWeatherData, Double> feelslikeColumn; // TableColumn for the feels-like temperature

    @FXML
    private TableColumn<TorontoWeatherData, Double> humidityColumn; // TableColumn for the humidity

    @FXML
    private TableColumn<TorontoWeatherData, Double> windSpeedColumn; // TableColumn for the wind speed

    @FXML
    private TableColumn<TorontoWeatherData, Double> pressureColumn; // TableColumn for the pressure

    @FXML
    private Button graphViewButton; // Button to switch to the graph view

    @FXML
    private AnchorPane tableViewPane; // AnchorPane containing the table view

    private DatabaseConnector databaseConnector = new DatabaseConnector(); // Database connection utility

    // Initialize method called after the FXML file has been loaded
    @FXML
    private void initialize() {
        // Initialize the columns with the property names of TorontoWeatherData
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        feelslikeColumn.setCellValueFactory(new PropertyValueFactory<>("feelslike"));
        humidityColumn.setCellValueFactory(new PropertyValueFactory<>("humidity"));
        windSpeedColumn.setCellValueFactory(new PropertyValueFactory<>("windSpeed"));
        pressureColumn.setCellValueFactory(new PropertyValueFactory<>("pressure"));

        // Load data into the table view
        loadData();

        // Set the action for the button to switch to graph view
        graphViewButton.setOnAction(event -> switchToGraphView());
    }

    // Method to load data from the database into the table view
    public void loadData() {
        List<TorontoWeatherData> dataList = new ArrayList<>(); // List to hold the data
        try (Connection conn = databaseConnector.connect(); Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM toronto_weather_data"; // SQL query to fetch all data
            ResultSet rs = stmt.executeQuery(query);

            // Iterate through the result set and add data to the list
            while (rs.next()) {
                dataList.add(new TorontoWeatherData(
                        rs.getString("date"),
                        rs.getDouble("temperature"),
                        rs.getDouble("feelslike"),
                        rs.getDouble("humidity"),
                        rs.getDouble("windspeed"),
                        rs.getDouble("pressure")
                ));
            }
            tableView.getItems().setAll(dataList); // Set the data in the table view
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }

    // Method to switch the view to the graph view
    private void switchToGraphView() {
        try {
            // Load the main view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            AnchorPane graphViewPane = loader.load(); // Load the graph view pane
            tableViewPane.getChildren().setAll(graphViewPane); // Set the table view pane's children to the graph view
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }
}
