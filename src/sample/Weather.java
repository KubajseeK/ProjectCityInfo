package sample;

public class Weather {
    private String name;
    private String country;
    private double temp;
    private long humidity;
    private double lon;
    private double lat;
    private int visibility;
    private long sunRise;
    private long sunSet;

    public Weather(String name, String country, double temp, long humidity, double lon, double lat, int visibility, long sunRise, long sunSet) {
        this.name = name;
        this.country = country;
        this.temp = temp;
        this.humidity = humidity;
        this.lon = lon;
        this.lat = lat;
        this.visibility = visibility;
        this.sunRise = sunRise;
        this.sunSet = sunSet;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getTemp() {
        return temp;
    }

    public long getHumidity() {
        return humidity;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public int getVisibility() {
        return visibility;
    }

    public long getSunRise() {
        return sunRise;
    }

    public long getSunSet() {
        return sunSet;
    }
}