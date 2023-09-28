import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(20))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();


        HttpRequest request = HttpRequest.newBuilder()
//                Тут я взял апишный урл в яндекс погоде и добавил параметры в виде широты и долготы Питера, так же добавил русский язык, количество дней прогноза 7, и расширенную информацию об осадках
                .uri(URI.create("https://api.weather.yandex.ru/v2/forecast?lat=59.57&lon=30.19&lang=ru_RU&limit=7&extra=true"))
                .GET()
//                В заголовках передал ключ API, который взял в ЛК разработчика в ядексе и accept  в виде Json
                .headers("X-Yandex-API-Key", "e9a0fae9-acd5-4a63-ac07-cd71f6f6284f", "accept", "application/json")
                .build();
// Тут сфрмировал ответ по запросу в виде строки и распечатал в консоле код ответа, заголовки и тело
        HttpResponse<String> jsonResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = mapper.readValue(jsonResponse.body(), WeatherResponse.class);
//        Тут я печатаю сразу вывод в консоль после маппинга ответа от яндекса
        System.out.println(weatherResponse.toString());
//        Тут создаю объект, при помощи которого будут производится манипуляции с БД
        DatabaseRepositorySQLite databaseRepositorySQLite = new DatabaseRepositorySQLite();
//        Тут очищаем нашу БД
        databaseRepositorySQLite.performDropTable();
//        Тут создаем таблицы с прогнозом на 7 дней и текущую
        databaseRepositorySQLite.createTable();
//        Тут записываем в БД ответ, полученный от яндекса
        databaseRepositorySQLite.saveWeatherData(weatherResponse);
//        Тут выводим в консоль погоду на 7 дней из БД
        databaseRepositorySQLite.getAllSavedDataForecast();
//        Тут выводим в консоль текущую погоду из БД
        databaseRepositorySQLite.getAllSavedDataFact();

    }
}


