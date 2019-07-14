package pl.sda;

import pl.sda.model.Current;
import pl.sda.model.Location;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "747c41bc2d0e41cda3881301191307");
        Current current = weatherService.getJSONData("Torun").getCityWeather();
        Location location = weatherService.getJSONData("Torun").getLocation();

        System.out.println("LAT: " + location.getLat());
        System.out.println("LON: " + location.getLon());
        System.out.println("YOOOOPY");
    }
}
