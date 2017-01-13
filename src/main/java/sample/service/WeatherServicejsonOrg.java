package sample.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import sample.model.Weather;
import sample.model.WeatherCondition;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.installLookAndFeel;


public class WeatherServicejsonOrg implements WeatherService{
    private String privateKey;

    public WeatherServicejsonOrg(String privateKey){
        this.privateKey = privateKey;
    }

    public Weather getWeatherFromUrl(String url, String city) {
        String finalUrl = url+"?key="+privateKey+"&q="+city;
        Weather weather = new Weather();
        try{
            JSONObject json = new JSONObject(IOUtils.toString(new URL(finalUrl), Charset.forName("UTF-8")));
            JSONObject currentWeather = json.getJSONObject("current");
            String location = city;
            double temperatureInCelsius = currentWeather.getDouble("temp_c");
            String lastUpdated = currentWeather.getString("last_updated");
            boolean isDay = currentWeather.getInt("is_day")==1 ? true : false;
            double feelsliketemperatureInCelsius = currentWeather.getDouble("feelslike_c");
            double pressureMB = currentWeather.getDouble("pressure_mb");
            JSONObject currentConditionWeather = currentWeather.getJSONObject("condition");
            String conditionText = currentConditionWeather.getString("text");
            String iconUrl = currentConditionWeather.getString("icon");
            int code = currentConditionWeather.getInt("code");

            WeatherCondition weatherCondition = new WeatherCondition(conditionText,iconUrl,code);
            weather.setDay(isDay);
            weather.setWeatherCondition(weatherCondition);
            weather.setLastUpdated(lastUpdated);
            weather.setTemperatureInCelsius(temperatureInCelsius);
            weather.setLocation(location);
            weather.setPressureMb(pressureMB);
            weather.setFeelsliketemperatureInCelsius(feelsliketemperatureInCelsius);


        }catch (IOException e){
            e.printStackTrace();
        }
        return weather;
    }

    public static void main(String[] args){
        WeatherServicejsonOrg weatherServicejsonOrg = new WeatherServicejsonOrg("2fa8f5ac394a4de19af145543161711");
        Weather weather = weatherServicejsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json", "Warsaw");
        System.out.println(weather);
    }

}


