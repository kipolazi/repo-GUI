import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
class Day {
    @JsonProperty("temp_min")
    public int getTemp_min() {
        return this.temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    int temp_min;

    @JsonProperty("temp_avg")
    public int getTemp_avg() {
        return this.temp_avg;
    }

    public void setTemp_avg(int temp_avg) {
        this.temp_avg = temp_avg;
    }

    int temp_avg;

    @JsonProperty("temp_max")
    public int getTemp_max() {
        return this.temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    int temp_max;

    @JsonProperty("condition")
    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    String condition;

}


@JsonIgnoreProperties(ignoreUnknown = true)
class Forecast {

    @JsonProperty("date")
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    @JsonProperty("parts")
    public Parts getParts() {
        return this.parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    Parts parts;

}

@JsonIgnoreProperties(ignoreUnknown = true)
class GeoObject {
    @JsonProperty("locality")
    public Locality getLocality() {
        return this.locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    Locality locality;

    @JsonProperty("province")
    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    Province province;

}


class Locality {
    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Parts {
    @JsonProperty("day")
    public Day getDay() {
        return this.day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    Day day;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Province {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Fact {
    @JsonProperty("temp")
    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    int temp;

    @JsonProperty("condition")
    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    String condition;

    @JsonProperty("wind_speed")
    public int getWind_speed() {
        return this.wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    int wind_speed;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("geo_object")
    public GeoObject getGeo_object() {
        return this.geo_object;
    }

    public void setGeo_object(GeoObject geo_object) {
        this.geo_object = geo_object;
    }

    GeoObject geo_object;

    @JsonProperty("forecasts")
    public ArrayList<Forecast> getForecasts() {
        return this.forecasts;
    }

    public void setForecasts(ArrayList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    ArrayList<Forecast> forecasts;

    @JsonProperty("fact")
    public Fact getFact() {
        return this.fact; }
    public void setFact(Fact fact) {
        this.fact = fact; }
    Fact fact;

    @Override
    public String toString() {
        System.out.println("Погода на 7 дней вперед");
        for (Forecast fo : forecasts) {
            System.out.println("В <" + getGeo_object().province.name + ", " + getGeo_object().locality.name + "> на дату = " + fo.date + " максимальная температура = " + fo.parts.day.temp_max + "℃ и ожидается " + fo.parts.day.condition);
        }
        System.out.println('\n' + "Текущая погода");
        return "В данный момент температура = " + fact.temp + "℃; ветер = " + fact.wind_speed + "м/с; наблюдается = " + fact.condition;
    }

}




