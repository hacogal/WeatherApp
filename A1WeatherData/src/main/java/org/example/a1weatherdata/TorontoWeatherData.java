package org.example.a1weatherdata;

public class TorontoWeatherData {
    private String date;
    private double temperature;
    private double feelslike;
    private double humidity;
    private double windSpeed;
    private double pressure;

    //Constructor

    public TorontoWeatherData(String date, double temperature, double feelslike, double humidity, double windSpeed, double pressure) {
        this.date = date;
        this.temperature = temperature;
        this.feelslike = feelslike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    //Getters and Setters

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getFeelslike() {
        return feelslike;
    }
    public void setFeelslike(double feelslike) {
        this.feelslike = feelslike;
    }
    public double getHumidity() {
        return humidity;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
    public double getPressure() {
        return pressure;
    }
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

}
