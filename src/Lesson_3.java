import java.util.Scanner;

public class Lesson_3 {
    public static void main(String[] args) {
        //  checkSum();               // 1.
        //  checkNum();               // 2.
        //  checkNumBool();           // 3.
        //  printStr();               // 4.
        //  checkYear();              // 5.
    }

    // 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    // от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

    public static boolean checkSum() {
        boolean sum = false;
        System.out.println("Введите число 1:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Введите число 2:");
        int b = scanner.nextInt();
        int c = a + b;
        if (c >= 10 && c <= 20) sum = true;
        System.out.println(sum);
        return sum;
    }

    // 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

    public static void checkNum() {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a < 0) System.out.println("Число отрицательное");
        else System.out.println("Число положительное");
    }

    // 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.

    public static boolean checkNumBool() {
        boolean b = false;
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a < 0) {
            b = true;
            System.out.println(b);
        } else System.out.println(b);
        return b;
    }

    // 4. Написать метод, которому в качестве аргументов передается строка и число,
    // метод должен отпечатать в консоль указанную строку, указанное количество раз.

    public static void printStr() {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Введите число:");
        int a = scanner.nextInt();
        for (int x = 0; x < a; x++)
            System.out.println(str);
    }

    // 5. Написать метод, который определяет, является ли год високосным,
    // и возвращает boolean (високосный - true, не високосный - false).
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean checkYear() {
        boolean b = false;
        System.out.println("Введите год:");
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) b = true;
        System.out.println(b);
        return b;
    }

    // 6. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0.

    public static void replace() {

    }
}