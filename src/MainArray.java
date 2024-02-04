/*  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    В методе main() вызвать полученный метод, обработать возможные исключения
    MyArraySizeException и MyArrayDataException и вывести результат расчета.    */
public class MainArray {
    private static String[][] arr1 = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    private static String[][] arr2 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
            {"9", "10", "11", "12"}, {"13", "1r; ", "15", "16"}};
    private static String[][] arr3 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
            {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
    
    public static void main(String[] args) {
        System.out.println("-------------------------------array 1---------------------------------");
        try {
            System.out.println("Сумма всех элементов массива arr1 = " + sumOfArr(arr1));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e);
        }
        System.out.println("-------------------------------array 2---------------------------------");
        try {
            System.out.println("Сумма всех элементов массива arr2 = " + sumOfArr(arr2));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e);
        }
        System.out.println("-------------------------------array 3---------------------------------");
        try {
            System.out.println("Сумма всех элементов массива arr3 = " + sumOfArr(arr3));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e);
        }
    }
    
    public static int sumOfArr(String[][] arr) throws RuntimeException {
        int sum = 0;
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Массив не соответствует размеру 4 Х 4.");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректные данные лежат в ячейке [" + i + "][" + j + "]." +
                            " Преобразование не удалось.");
                }
            }
        }
        return sum;
    }
}
