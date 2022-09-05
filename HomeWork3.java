import java.util.*;
import java.util.stream.IntStream;

public class HomeWork3 {

    public static void main(String[] args) {
        number1();
        System.out.println("**************************");
        number2();
        System.out.println("**************************");
        number3();
        System.out.println("**************************");
        number4();
        System.out.println("**************************");
        System.out.println(Arrays.toString(number5(10, 15)));
        System.out.println("**************************");
        number6();
        System.out.println("**************************");
        System.out.println(number7());
        System.out.println("Cancel Home work 3!!!!!!!!!!!");


    }


    //1 пункт ДЗ
    public static void number1() {
        int[] arr = {1, 0, 1, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //2 пункт ДЗ
    public static void number2() {
        int[] arrZero = new int[100];
        for (int i = 0; i < arrZero.length; i++) {
            arrZero[i] = 1 + i;
        }
        System.out.println(Arrays.toString(arrZero));
    }

    //3 пункт ДЗ
    public static void number3() {
        int[] arrMultiply = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrMultiply.length; i++) {
            if (arrMultiply[i] < 6) {
                arrMultiply[i] = arrMultiply[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arrMultiply));
    }

    //4 пункт ДЗ
    public static void number4() {
        int[][] arrSquare = new int[10][10];
        int counter = 0;
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = 0, x = arrSquare.length - 1; j < arrSquare.length; j++, x--) {
                arrSquare[i][j] = counter;
                if (arrSquare[i] == arrSquare[j] || i == x) {
                    arrSquare[i][j] = 1;
                }
                System.out.print(arrSquare[i][j] + " ");
                counter++;
            }
            System.out.println();

        }
    }

    //5 пункт ДЗ
    public static int[] number5(int len, int initialValue) {
        int[] arrReturn = new int[len];
        for (int i = 0; i < len; i++) {
            arrReturn[i] = initialValue;
        }
        return arrReturn;
    }

    //6 пункт ДЗ. Здесь я задал длину массива "arrMinMax" через переменную int(число в которой рандомно генерируется в диапазоне [10;20]).
    public static void number6() {
        int a = (int) (10 + Math.random() * 11);
        int[] arrMinMax = new int[a];
        int indexOfMax = arrMinMax[0];
        int indexOfMin = arrMinMax[0];
        for (int i = indexOfMax; (i < arrMinMax.length); i++) {
            arrMinMax[i] = i;
            if (arrMinMax[i] > indexOfMax) {
                indexOfMax = arrMinMax[i];
            } else
                indexOfMin = arrMinMax[i];
        }
        System.out.println(Arrays.toString(arrMinMax));
        System.out.println("Max " + indexOfMax + "\n" + "Min " + indexOfMin);
    }

    //7 пункт ДЗ
    public static boolean number7() {
        int[] arrSumLeftRight = new int[]{3, 4, 5, 6, 6, 5, 4, 3};
        boolean sumSumRightLeft = false;
        int arrSum = 0;
        for (int i = 0; i < arrSumLeftRight.length; i++) {
            arrSum += arrSumLeftRight[i];
        }
        int right = 0;
        for (int i = 0; i < arrSumLeftRight.length; i++) {
            right += arrSumLeftRight[i];
            if (right == arrSum - right) {
                sumSumRightLeft = true;
            }

        }
        System.out.print("Исходный(заданный нами) массив: " + Arrays.toString(arrSumLeftRight) + " - ");
        return sumSumRightLeft;
    }
}
