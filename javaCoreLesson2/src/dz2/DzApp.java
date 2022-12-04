package dz2;

public class DzApp {
    static int size1 = 4;
    static int size2 = 4;


    public static void main(String[] args) {
        String[][] arrayNoError = {{"5", "2", "6", "7"}, {"9", "5", "7", "6"}, {"9", "9", "5", "7"}, {"6", "5", "7", "2"}};
        String[][] MyArrayDataException = {{"5", "2", "6", "7"}, {"9", "5", "j", "6"}, {"9", "9", "5", "7"}, {"6", "5", "7", "2"}};
        String[][] MyArraySizeException = {{"5", "2"}, {"9", "5", "7", "6"}, {"9", "9", "5", "7"}, {"6", "5", "7", "2"}};

        try {
            System.out.println("Сумма массива: " + getSumm(arrayNoError));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(MyArrayDataException));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(MyArraySizeException));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }


    }

    private static void checkLengthArray(String[][] array) throws MyArraySizeException {
        if (array.length != size1 || array[0].length != size2) throw new MyArraySizeException();
    }

    static Integer getSumm(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkLengthArray(array);
        Integer result = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Возникает ошибка в позиции " + i + " , " + j);
        }
        return result;

    }


}
