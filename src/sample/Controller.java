package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.util.List;

public class Controller {

    public Label lblPop;

    List countries;
    List cities;
    String country;

    public ComboBox comboCountry;
    public ComboBox comboCity;


    public Controller() {
        Database database = new Database();
        try {
            countries = database.getListOfCountries();
            cities = database.getListOfCities(country);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickComboCountry(Event event) {
        comboCountry.getItems().setAll(countries);
    }

    public void clickComboCity(Event event) {
        country = (String) comboCountry.getValue();
        System.out.println(country);

        try {
            cities = new Database().getListOfCities(country);
            comboCity.getItems().setAll(cities);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickBtnShow(ActionEvent actionEvent) {
        String city = (String) comboCity.getValue();
        System.out.println(city);

        try {
            String population = new Database().getPopulation((String) comboCity.getValue());
            lblPop.setText("Population: " + population);
            System.out.println(population);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String formatPopString(int population) {
        String data = String.valueOf(population);
        DecimalFormat formatter = new DecimalFormat("#,###");
        String yourFormattedString = formatter.format(population);
        return yourFormattedString;
    }
}