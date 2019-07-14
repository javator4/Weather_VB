package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Current {

    private float last_updated_epoch;
    private String last_updated;
    private float temp_c;
    private float temp_f;
    private int is_day;
    private Condition condition;
    private float wind_mph;
    private float wind_kmph;
    private int wind_degree;
    private String wind_dir;
    private float pressure_mb;
    private float pressure_in;
    private int precip_mm;
    private int precip_in;
    private int humidity;
    private int cloud;
    private float feelslike_c;
    private float feelslike_f;
    private float vis_km;
    private int vis_miles;
    private int uv;
    private float gust_mph;
    private float gust_kph;


}
