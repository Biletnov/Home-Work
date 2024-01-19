/*1. Создайте метод printThreeWords(), который при вызове должен отпечатать в
столбец три слова: Orange, Banana, Apple.
2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
 и инициализируйте их любыми значениями, которыми захотите. Далее метод должен
 просуммировать эти переменные, и если их сумма больше или равна 0,
 то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
3. Создайте метод printColor() в теле которого задайте int переменную value
и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
 то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно)
  до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
 и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
 то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
5. Методы из пунктов 1-5 вызовите из метода main()
и посмотрите корректно ли они работают.*/
public class Lesson_2 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = -21;
        int b = 1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 513;
        int b = 51;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}