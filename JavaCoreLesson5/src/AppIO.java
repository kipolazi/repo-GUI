import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppIO {
    public static String header = "Value 1" + ";" + "Value 2" + ";" + "Value 3" + '\n';
    public static ArrayList<Lines> linesArrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        Тут создал строки с цифрами и записал в CSV через Stream
        createLinesArrayList();
        outStreamWrite();
        AppData appData = save();



    }

    public static void outStreamWrite() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\r.volovik\\Desktop\\Личное\\test.csv");
        for (byte n : header.getBytes(StandardCharsets.UTF_8)) {
            fileOutputStream.write(n);
        }
        for (Lines lines : linesArrayList) {
            String arrValue = lines.getValue() + ";" + lines.getValue2() + ";" + lines.getValue3() + '\n';
            for (byte n : arrValue.getBytes(StandardCharsets.UTF_8)) {
                fileOutputStream.write(n);
            }
        }
    }

    public static void createLinesArrayList() {
        for (int i = 0; i < 200; i++) {
            linesArrayList.add(new Lines(i, i += 1, i += 2));
        }
    }

    public static AppData save() throws IOException, NullPointerException {
        AppData appData = new AppData();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\r.volovik\\Desktop\\Личное\\test.csv"), 500);
            List<List<String>> res = new ArrayList<>();
            String line = bufferedReader.readLine();
            appData.setName(line.split(";"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");
                res.add(Arrays.asList(values));
            }

            int[][] resData = new int[res.size()][3];
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    resData[i][j] = Integer.valueOf(res.get(i).get(j));
                }
            }
            appData.setData(resData);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return appData;

    }
}
