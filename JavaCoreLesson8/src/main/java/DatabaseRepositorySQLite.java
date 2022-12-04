
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLite implements DataBaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String createTableForecastQuery = "CREATE TABLE IF NOT EXISTS weather_forecast " +
            "( forecast_id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "forecast_province_name TEXT NOT NULL, \n" +
            "forecast_locality_name TEXT NOT NULL, \n" +
            "forecast_date TEXT NOT NULL, \n" +
            "forecast_day_temp_max REAL NOT NULL, \n" +
            "forecast_condition TEXT NOT NULL);";

    String createTableFactQuery = "CREATE TABLE IF NOT EXISTS weather_fact " +
            "( fact_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "fact_wind_speed REAL NOT NULL,\n" +
            "fact_temp REAL NOT NULL,\n" +
            "fact_condition TEXT NOT NULL);";


    String insertWeatherForecastQuery = "INSERT INTO weather_forecast (forecast_province_name, forecast_locality_name, forecast_date, forecast_day_temp_max, forecast_condition) VALUES (?,?,?,?,?)";
    String insertWeatherFactQuery = "INSERT INTO weather_fact (fact_wind_speed, fact_temp,  fact_condition) VALUES (?,?,?)";

    public DatabaseRepositorySQLite() {
    }

    public void performDropTable() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson8.s3db");
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS weather_forecast");
        statement.executeUpdate("DROP TABLE IF EXISTS weather_fact");
    }

    public void createTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson8.s3db")) {
            connection.createStatement().execute(createTableForecastQuery);
            connection.createStatement().execute(createTableFactQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public boolean saveWeatherData(WeatherResponse weatherData) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson8.s3db");
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherForecastQuery)) {
            saveWeather.setString(1, weatherData.geo_object.province.name);
            saveWeather.setString(2, weatherData.geo_object.locality.name);
            for (Forecast fo : weatherData.forecasts) {
                saveWeather.setString(3, fo.date);
                saveWeather.setInt(4, fo.parts.day.temp_max);
                saveWeather.setString(5, fo.parts.day.condition);
                saveWeather.execute();
            }
            PreparedStatement saveWeather1 = connection.prepareStatement(insertWeatherFactQuery);
            saveWeather1.setInt(1, weatherData.fact.wind_speed);
            saveWeather1.setInt(2, weatherData.fact.temp);
            saveWeather1.setString(3, weatherData.fact.condition);
            saveWeather1.execute();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherResponseDBForecast> getAllSavedDataForecast() throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson8.s3db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM weather_forecast");
        List<WeatherResponseDBForecast> weatherResponsesDBForecast = new ArrayList<>();
        while (resultSet.next()) {
            weatherResponsesDBForecast.add(new WeatherResponseDBForecast(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6)));
        }
        System.out.println('\n' + "Отображаем прогназ на 7 дней вперед, который вытянули из БД:");
        for (WeatherResponseDBForecast we : weatherResponsesDBForecast) {
            System.out.println("В <" + we.province + ", " + we.locality + "> на дату = " + we.date + " максимальная температура = " + we.dayTempMax + "℃ и ожидается " + we.condition);
        }


        return null;
    }

    @Override
    public List<WeatherResponseDBFact> getAllSavedDataFact() throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Lesson8.s3db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM weather_fact");
        List<WeatherResponseDBFact> weatherResponsesDBFact = new ArrayList<>();
        while (resultSet.next()) {
            weatherResponsesDBFact.add(new WeatherResponseDBFact(resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4)));
        }
        System.out.println('\n' + "Отображаем текущий прогноз, который вытянули из БД:" + '\n' +
               "В данный момент температура = " + weatherResponsesDBFact.iterator().next().temp + "; ветер = " + weatherResponsesDBFact.iterator().next().windSpeed + "м/с; наблюдается = " + weatherResponsesDBFact.iterator().next().condition);

        return null;
    }

    class WeatherResponseDBForecast {
        private String province;
        private String locality;
        private String date;
        private int dayTempMax;
        private String condition;

        public WeatherResponseDBForecast(String province, String locality, String date, int dayTempMax, String condition) {
            this.province = province;
            this.locality = locality;
            this.date = date;
            this.dayTempMax = dayTempMax;
            this.condition = condition;
        }
    }

    class WeatherResponseDBFact {
        private int windSpeed;
        private int temp;
        private String condition;

        public WeatherResponseDBFact(int windSpeed, int temp, String condition) {
            this.windSpeed = windSpeed;
            this.temp = temp;
            this.condition = condition;
        }
    }
}



