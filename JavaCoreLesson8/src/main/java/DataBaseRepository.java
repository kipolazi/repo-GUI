import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DataBaseRepository {
    boolean saveWeatherData(WeatherResponse weatherData) throws SQLException;

    List<DatabaseRepositorySQLite.WeatherResponseDBForecast> getAllSavedDataForecast() throws IOException, SQLException;

    List<DatabaseRepositorySQLite.WeatherResponseDBFact> getAllSavedDataFact() throws IOException, SQLException;
}
