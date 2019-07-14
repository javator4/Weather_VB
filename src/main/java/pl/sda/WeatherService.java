package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String url;
    private String key;
    private String adress;
    private String data = "";

    public WeatherService(String url, String key) {

        this.url = url;
        this.key = key;
        this.adress = this.url + "?key=" + key + "&q=";
    }

    public WeatherService getJSONData(String city) {
        if (data.isEmpty()) {
            this.adress = this.adress + city;
            try {
                this.data = IOUtils.toString(new URL(this.adress),
                        Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public Current getCityWeather() {

        JSONObject jsonObject = new JSONObject(this.data);

           /* String temp = jsonObject.getJSONObject("current").get("temp_c").toString();
            System.out.println(temp);

            Current current = new Current();
            current.setTemp_c(Float.parseFloat(temp));

            String cloud = jsonObject.getJSONObject("current").get("cloud").toString();
            System.out.println(cloud);

            String vis_km = jsonObject.getJSONObject("current").get("vis_km").toString();
            System.out.println(vis_km);

            String last_updated_epoch = jsonObject.getJSONObject("current").get("last_updated_epoch").toString();
            System.out.println(last_updated_epoch);

            String wind_mph = jsonObject.getJSONObject("current").get("wind_mph").toString();
            System.out.println(wind_mph);

            String wind_dir = jsonObject.getJSONObject("current").get("wind_dir").toString();
            System.out.println(wind_dir);

            String pressure_mb = jsonObject.getJSONObject("current").get("pressure_mb").toString();
            System.out.println(pressure_mb);



            current.setCloud(Integer.parseInt(cloud));
            current.setVis_km(Float.parseFloat(vis_km));
            current.setLast_updated_epoch(Integer.parseInt(last_updated_epoch));
            current.setWind_mph(Float.parseFloat(wind_mph));
            current.setPressure_mb(Float.parseFloat(pressure_mb));*/

        Current current = Current.builder()
                .temp_c(22)
                .cloud(25)
                .vis_km(15)
                .last_updated_epoch(246)
                .wind_mph(16)
                .wind_dir("NNE")
                .pressure_mb(15).build();

        return current;
    }

    public Location getLocation() {

        JSONObject jsonObject = new JSONObject(this.data);

        String lat = jsonObject.getJSONObject("location").get("lat").toString();
        String lon = jsonObject.getJSONObject("location").get("lon").toString();
        Location location = Location.builder()
                .lat(Double.parseDouble(lat))
                .lon(Double.parseDouble(lon)).build();
        return location;

    }
}



