package exercise1;

import java.util.ArrayList;
import java.util.Random;

//1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.
public class Main {
    public static void main(String[] args) {
        GenerateRandom();
    }
    
    public static void GenerateRandom() {
        ArrayList<Integer> Array = new ArrayList<>();
        int number;
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            number = random.nextInt() % 250;
            Array.add(number);
        }
        System.out.println("Сгенерированный массив:" + Array);
        int num = (int) (Array.stream().filter((n) -> (n % 2) == 0)).count();
        System.out.println("Четных чисел: " + num);
    }
}
