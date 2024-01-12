
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
        int a = -21;
        int b = 1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else  {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        }
        else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 513;
        int b = 51;
        if(a >= b) {
            System.out.println("a >= b");
        }
        else  {
            System.out.println("a < b");
        }
    }
}