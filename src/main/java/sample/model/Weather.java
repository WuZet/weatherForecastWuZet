package sample.model;


public class Weather {
    private double temperatureInCelsius;
    private String lastUpdated;
    private double feelsliketemperatureInCelsius;
    private boolean isDay;
    private double pressureMb;
    private String location;
    private WeatherCondition weatherCondition;


    public Weather(){}

    public Weather(double temperatureInCelsius, String lastUpdated, double feelsliketemperatureInCelsius, boolean isDay, double pressureMb, String location) {
        this.temperatureInCelsius = temperatureInCelsius;
        this.lastUpdated = lastUpdated;
        this.feelsliketemperatureInCelsius = feelsliketemperatureInCelsius;
        //this.iconUrl = iconUrl;
        this.isDay = isDay;
        this.pressureMb = pressureMb;
        this.location = location;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public double getFeelsliketemperatureInCelsius() {
        return feelsliketemperatureInCelsius;
    }

    public void setFeelsliketemperatureInCelsius(double feelsliketemperatureInCelsius) {
        this.feelsliketemperatureInCelsius = feelsliketemperatureInCelsius;
    }


    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperatureInCelsius=" + temperatureInCelsius +
                ", lastUpdated=" + lastUpdated +
                ", feelsliketemperatureInCelsius=" + feelsliketemperatureInCelsius +
                ", isDay=" + isDay +
                ", pressureMb=" + pressureMb +
                ", location='" + location + '\'' +
                ", weatherCondition=" + weatherCondition +
                '}';
    }
}
