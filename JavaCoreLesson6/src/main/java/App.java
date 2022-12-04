import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException, NullPointerException {
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
        System.out.println(jsonResponse.previousResponse());
        System.out.println(jsonResponse.headers());
        System.out.println(jsonResponse.statusCode());
        System.out.println(jsonResponse.body());


    }


}
