package sample.service;

import sample.model.Weather;

public interface WeatherService {
    Weather getWeatherFromUrl(String url, String city);
}
