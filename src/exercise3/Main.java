package exercise3;

import java.util.Arrays;
import java.util.List;

//3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
// Необходимо отсортировать строки по возрастанию и добавить их в массив;
public class Main {
    public static void main(String[] args) {
        List<String> collection = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        collection.sort((s1, s2) -> {
            int num1 = Integer.parseInt(s1.substring(1));
            int num2 = Integer.parseInt(s2.substring(1));
            return Integer.compare(num1, num2);
        });
        String[] sortedArray = collection.toArray(new String[0]);
        for (String s : sortedArray) {
            System.out.println(s);
        }
    }
}
