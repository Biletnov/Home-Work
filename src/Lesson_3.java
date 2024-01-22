import java.util.Arrays;
import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {
        System.out.println(checkSum());
        checkNum();
        System.out.println(checkNumBool());
        printStr();
        System.out.println(checkYear());
        replace();
        fillArr();
        multiplyArr();
        xMatrix();
        createArr();
    }
    
    // 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    // от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    
    public static boolean checkSum() {
        System.out.println("Введите число 1:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Введите число 2:");
        int b = scanner.nextInt();
        int c = a + b;
        boolean sum = c >= 10 && c <= 20;
        return sum;
    }
    
    // 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    
    public static void checkNum() {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }
    
    // 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    
    public static boolean checkNumBool() {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        boolean bool = (a < 0);
        return bool;
    }
    
    // 4. Написать метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз.
    
    public static void printStr() {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Введите число:");
        int a = scanner.nextInt();
        for (int x = 0; x < a; x++) System.out.println(str);
    }
    
    // 5. Написать метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    
    public static boolean checkYear() {
        System.out.println("Введите год:");
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        boolean bool = (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0));
        return bool;
    }
    
    // 6. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0.
    
    public static void replace() {
        int[] arr = new int[]{0, 0, 1, 0, 1, 0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
    
    // 7. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    
    public static void fillArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
    
    // 8. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему циклом,
    // и числа меньшие 6 умножить на 2;
    
    public static void multiplyArr() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
    
    // 9. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    
    public static void xMatrix() {
        int[][] matrix = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == j || i + j == 14) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // 10. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    
    public static int[] createArr() {
        System.out.println("Введите длину массива:");
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        System.out.println("Введите целочисленное значение массива:");
        int initialValue = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.print(Arrays.toString(arr));
        return arr;
    }
}