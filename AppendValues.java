import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppendValues {
    static String spreadsheetId = "1i-3wjk7RlOlekfJLMHT1QjBPWwCVPkTM7tly4soegKw";
    static String range = "A1";
    static String valueInputOption = "USER_ENTERED";
    static String insertDataOption = "INSERT_ROWS";
    static List<List<Object>> values = null;

    public static void main(String[] args) throws IOException, CsvException, NoSuchAlgorithmException {
//        Тут мы вызываем метод для получения csv файла с багами через webDriver
        CSVFromJira.csvFromJira();
//        Тут мы вызываем метод, который очищает таблицу
        EmptyValues.emptyValues();
//        Тут мы получаем данные из файла, для дальнейшей их передачи в метод добавления данных
        AppendValues.getValues();
//        Тут мы вызываем метод для добавления данных в очищенную ранее таблицу
        try {
            AppendValues.appendValues(spreadsheetId, range, valueInputOption, insertDataOption, values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Метод для добавления данных в конец таблицы
    public static AppendValuesResponse appendValues(String spreadsheetId,
                                                    String range,
                                                    String valueInputOption,
                                                    String insertDataOption,
                                                    List<List<Object>> values)
            throws IOException {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault()
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(
                credentials);

        // Create the sheets API client
        Sheets service = new Sheets.Builder(new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                requestInitializer)
                .setApplicationName("Sheets samples")
                .build();

        AppendValuesResponse result = null;
        try {
            // Append values to the specified range.
            ValueRange body = new ValueRange()
                    .setValues(values);
            result = service.spreadsheets().values().append(spreadsheetId, range, body)
                    .setValueInputOption(valueInputOption)
                    .setInsertDataOption(insertDataOption)
                    .execute();
            // Prints the spreadsheet with appended values.
            System.out.printf("%d cells appended.", result.getUpdates().getUpdatedCells());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 404) {
                System.out.printf("Spreadsheet not found with id '%s'.\n", spreadsheetId);
            } else {
                throw e;
            }
        }
        return result;
    }

    //        Читаем csv файл, и записываем его в values, для дальнейшей передачи в ValueRange
    public static List<List<Object>> getValues() throws IOException, CsvException {
        CSVReader reader;
        reader = new CSVReader(new FileReader(getFirstFile()));
        List<String[]> rows = reader.readAll();
//        rows.remove(0);
        values = new ArrayList<>();
        int[] columnIndexes = {1, 3, 4, 6, 7};
        for (String[] row : rows) {
            List<Object> newRow = new ArrayList<>();
            for (int i : columnIndexes) {
                newRow.add(row[i]);
            }
            values.add(newRow);
        }
        return values;
    }


    //     Здесь мы получаем файл с самой последней датой создания/изменения (берем его, потому что чуть ранее получаем csv файл с багами при помощи selenium)
    public static File getFirstFile() throws IOException {
//        Путь к папке, где лежит выгрузка
        String folderPath = "C:\\Users\\r.volovik\\Downloads";
//        Создаем объект path для этой папки
        Path path = Paths.get(folderPath);
//         Получаем список всех файлов из папки
        File[] files = new File(folderPath).listFiles();
//        Преобразуем объекты path к file и фильтруем по последней модификации
        File latestFile = Files.walk(path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .max(Comparator.comparingLong(File::lastModified)).orElse(null);

        if (latestFile != null) {
            System.out.println("Последний файл: " + latestFile.getName());
        } else {
            System.out.println("Нету такого");
        }
        return latestFile;
    }
}

