package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.Weather;
import sample.service.WeatherServicejsonOrg;


import java.net.URL;
import java.util.ResourceBundle;
import static java.awt.SystemColor.text;

public class Controller implements Initializable{

    @FXML
    private Label cityLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label textConditionLabel;

    @FXML
    private ImageView iconLabel;

    @FXML
    private Button sendButton;

    @FXML
    private TextField cityTextField;

    @FXML
    public void onEnter(ActionEvent actionEvent){
        setValuesComponentsFromServer(cityTextField.getText());
    }


    private Weather currentWeather;

    public void initialize(URL location, ResourceBundle resources) {
        setValuesComponentsFromServer(null);
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                setValuesComponentsFromServer(cityTextField.getText());
            }
        });
    }

    private void setValuesComponentsFromServer(String myCity)   {
        WeatherServicejsonOrg weatherServicejsonOrg = new WeatherServicejsonOrg("2fa8f5ac394a4de19af145543161711");
        String city = myCity !=null ? myCity : "Warsaw";
        currentWeather = weatherServicejsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json", city);
        dateLabel.setText(currentWeather.getLastUpdated());
        cityLabel.setText(currentWeather.getLocation());
        temperatureLabel.setText(String.valueOf(currentWeather.getTemperatureInCelsius()));
        textConditionLabel.setText(currentWeather.getWeatherCondition().getText());
        Image image = new Image("http:" +currentWeather.getWeatherCondition().getIconUrl(), true);
        iconLabel.setImage(image);
    }


}

