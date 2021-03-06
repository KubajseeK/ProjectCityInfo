package sample;

import org.json.*;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebWeather {

    public Weather getData(String city, String code2) {
        Weather weather = null;
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + code2 +
                    "&units=metric&appid=cc5a4588efb2b78dbb431880e398c31d");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if(conn.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String output = br.readLine();
                JSONObject jsonObject = new JSONObject(output);

                String name = new JSONObject(output).getString("name");
                String country = new JSONObject(output).getJSONObject("sys").getString("country");
                double temp = new JSONObject(output).getJSONObject("main").getDouble("temp");
                int humidity = new JSONObject(output).getJSONObject("main").getInt("humidity");
                double lon = new JSONObject(output).getJSONObject("coord").getDouble("lon");
                double lat = new JSONObject(output).getJSONObject("coord").getDouble("lat");
                int visibility = jsonObject.getInt("visibility");
                long sunrise = jsonObject.getJSONObject("sys").getLong("sunrise");
                long sunset = jsonObject.getJSONObject("sys").getLong("sunset");

                System.out.println("\n" + "Country: " + country + "\n" + "City: "
                        + name + "\n" + "Temperature: " + temp + "\n" + "Humidity: " + humidity + "\n"
                        + "Coordinates: " + lon + " " + lat );
                return new Weather(name, country, temp, humidity, lon, lat, visibility, sunrise, sunset);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTemperatureFromJSON(String output) {
        String[] parts = output.split(":");
        String[] one = parts[11].split(",");
        return one[0];
    }

    public String getHumidityFromJSON(String output) {
        String[] parts = output.split(":");
        String[] one = parts[16].split(",");
        return one[0].substring(0, 2);
    }
}