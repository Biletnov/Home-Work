
public class Main {
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
        int a = -1;
        int b = -1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        if (sum < 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        }
        if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 5;
        if(a >= b) {
            System.out.println("a >= b");
        }
        if(a < b) {
            System.out.println("a < b");
        }
    }
}