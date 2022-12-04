import java.util.*;

public class DemoApp {

    public static void main(String[] args) {
//        Первый пункт ДЗ
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Голубь", "Кошка", "Голубь", "Мышь", "Дверь", "Голубь", "Окно", "Полотенце", "Окно", "Мотоцикл", "Лопата"));
        HashSet<String> set = new HashSet<>(list);
        System.out.println(set);
        System.out.println(amount(list, "Голубь"));

//        Второй пункт ДЗ
        NumberPhone test1 = new NumberPhone();
        test1.add("89674445456", "Иванов");
        test1.add("89675256332", "Сидоров");
        test1.add("89674445457", "Иванов");
        test1.add("89675556330", "Сидоров");
        test1.add("89674445486", "Маркин");
        test1.add("89675559332", "Артемов");
        test1.add("89677445456", "Книгин");
        test1.add("89675556332", "Книгин");
        System.out.println(test1.get("Сидоров"));
        System.out.println(test1.get("Книгин"));
    }

    //    Сделал универсальный метод для подсчета повторяющихся слов. Изначально проверяет наличие введенного нами слова во вхождении метода и если таковое имеется, то бегает по коолекции и сравнивает текущее слово со всеми словами колекции и если находит совпадения инкрементирует промежуточную переменную
    public static String amount(ArrayList<String> list, String word) {
        if (list.contains(word)) {
            String result = word + " = ";
            int resulAmount = 0;
            for (String amount : list) {
                if (amount.equals(word)) {
                    resulAmount++;
                }
            }
            return result + resulAmount;
        } else return "Такого слова нет в списке";
    }


}
