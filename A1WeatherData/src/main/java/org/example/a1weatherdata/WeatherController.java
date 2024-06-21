package org.example.a1weatherdata;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class WeatherController {

    // FXML annotations to link to the UI components defined in the FXML file
    @FXML
    private AnchorPane mainPane; // The main pane where different views will be loaded

    @FXML
    private BarChart<String, Number> barChart; // The bar chart to display weather data

    private DatabaseConnector databaseConnector = new DatabaseConnector(); // Database connection utility

    // Initialize method called after the FXML file has been loaded
    @FXML
    private void initialize() {
        loadTempData(); // Load temperature data by default when the application starts
    }

    // Method to load temperature data into the bar chart
    @FXML
    private void loadTempData() {
        loadChartData("temperature", "Temperature", "°C");
    }

    // Method to load "Feels Like" temperature data into the bar chart
    @FXML
    private void loadFeelslikeData() {
        loadChartData("feelslike", "Feels Like", "°C");
    }

    // Method to load humidity data into the bar chart
    @FXML
    private void loadHumidityData() {
        loadChartData("humidity", "Humidity", "%");
    }

    // Method to load wind speed data into the bar chart
    @FXML
    private void loadWindSpeedData() {
        loadChartData("windspeed", "Wind Speed", "km/h");
    }

    // Method to load pressure data into the bar chart
    @FXML
    private void loadPreassureData () {
        loadChartData("pressure", "Pressure", "mb");
    }

    // Generic method to load chart data based on the selected column
    private void loadChartData(String columnName, String seriesName, String yAxisLabel) {
        barChart.getData().clear(); // Clear existing data in the bar chart
        try (Connection conn = databaseConnector.connect(); Statement stmt = conn.createStatement()) {
            // SQL query to fetch the date and the specified column from the database
            String query = "SELECT date, " + columnName + " FROM toronto_weather_data";
            ResultSet rs = stmt.executeQuery(query);

            // Create a new series for the bar chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(seriesName); // Set the name of the series

            // Iterate through the result set and add data to the series
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString("date"), rs.getDouble(columnName)));
            }

            // Add the series to the bar chart
            barChart.getData().add(series);
            // Set the label of the Y-axis
            barChart.getYAxis().setLabel(yAxisLabel);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }

    // Method to switch the view to the table view
    @FXML
    private void switchToTableView() {
        try {
            // Load the table view FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
            AnchorPane tableViewPane = loader.load(); // Load the table view pane
            mainPane.getChildren().setAll(tableViewPane); // Set the main pane's children to the table view

            // Get the controller for the table view and load data into it
            TableViewController tableViewController = loader.getController();
            tableViewController.loadData();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }
}
