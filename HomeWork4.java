import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    Random random;
    Scanner scanner;
    char[][] table;

    HomeWork4() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    public static void main(String[] args) {
        new HomeWork4().game();
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (checkWin('x')) {
                System.out.println("You WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, draw!");
                break;
            }
            turnAI();
            printTable();
            if (checkWin('o')) {
                System.out.println("AI Win");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, draw");
                break;
            }
        }
        System.out.println("Game Over");
        printTable();


    }

    private void initTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = '_';
            }
        }
    }

    private void printTable() {
        System.out.println("Введите число от 1 до 3");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void turnHuman() {
        int x, y;
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            if (!isCellValid(x, y)) {
                System.out.println("Вы ввели неверное значение, введите верное!");
            }
        }
        while (!isCellValid(x, y));
        table[x][y] = 'x';
    }

    private void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        }
        while (!isCellValid(x, y));
        table[x][y] = 'о';
    }

    private boolean isTableFull() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 3 || y > 3) {
            return false;
        }
        return table[x][y] == '_';
    }
//Переделал общую проверку победы  под универсальную
    private boolean checkWin(char symbol) {
        int rows, cols;
        for (int i = 0; i < table.length; i++) {
            rows = 0;
            cols = 0;
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == symbol) {
                    rows++;
                }
                if (table[j][i] == symbol) {
                    cols++;
                }

                if (rows >= table.length || cols >= table.length || checkDiagonal(symbol)) return true;
            }
//        if (table[0][0] == symbol && table[0][1] == symbol && table[0][2] == symbol) return true;
//        if (table[1][0] == symbol && table[1][1] == symbol && table[1][2] == symbol) return true;
//        if (table[2][0] == symbol && table[2][1] == symbol && table[2][2] == symbol) return true;
//        //columns
//        if (table[0][0] == symbol && table[1][0] == symbol && table[2][0] == symbol) return true;
//        if (table[0][1] == symbol && table[1][1] == symbol && table[2][1] == symbol) return true;
//        if (table[0][2] == symbol && table[1][2] == symbol && table[2][2] == symbol) return true;
//        //diag
//        if (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol) return true;
//        if (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol) return true;
        }
        return false;
    }
//Добавил проверку по диоганали
    boolean checkDiagonal(char symbol) {
        int leftDiagonal = 0, rightDiagonal = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0, x = table.length - 1; j < table.length; j++, x--) {
                if (table[i] == table[j] & table[i][j] == symbol) {
                    leftDiagonal++;
                }
                if (i == x & table[i][j] == symbol) {
                    rightDiagonal++;
                }
            }
            if (leftDiagonal >= table.length || rightDiagonal >= table.length) return true;
        }
        return false;

    }

}