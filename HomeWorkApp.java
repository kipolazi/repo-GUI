public class HomeWorkApp {

    //  Первый пункт ДЗ
    public static void main(String[] args) {
        printThreeWords("Orange", "Banana", "Apple");
        System.out.println("*******************************");
        checkSumSign(-5, 4);
        System.out.println("*******************************");
        printColor(101);
        System.out.println("*******************************");
        compareNumbers(-689, 589);

    }

    //   Второй пункт ДЗ, сделал метод немного универсальнее
    public static void printThreeWords(String a, String b, String c) {
        System.out.println(a + "\n" + b + "\n" + c);

    }

    //   Третий пункт ДЗ
    public static void checkSumSign(int a, int b) {
        if (a + b >= 0) {
            System.out.println("Сумма положительная!");
        }
        System.out.println("Сумма отрицательная!");

    }

    //   Четвертый пункт ДЗ
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленный");
        }

    }
    //   Пятый пункт ДЗ
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }

}
