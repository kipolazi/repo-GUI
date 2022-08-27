public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(checkSum(5, 17));
        System.out.println("******************************");
        checkNumber(-2);
        System.out.println("******************************");
        System.out.println(checkNumberOpposite(8));
        System.out.println("******************************");
        printString();
        System.out.println("******************************");
        System.out.println(leapYear(100));


    }

    //Первый пункт ДЗ
    static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20 ? true : false;
    }

    //Второй пункт ДЗ
    static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Третий пункт ДЗ
    static boolean checkNumberOpposite(int a) {
        return a < 0 ? true : false;
    }

    //Четвертый пункт ДЗ
    static void printString() {
        String printed = "Я печатаю эту строку указанное количество раз";
        int a = 10;
        for (int i = 0; i < a; i++) {
            System.out.println(printed);
        }
    }

    //Пятый пункт ДЗ
    static boolean leapYear(int a) {
        if (a % 4 == 0 && a % 400 == 0 || a % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
