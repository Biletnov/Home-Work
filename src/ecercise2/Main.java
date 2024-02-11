package ecercise2;

import java.util.ArrayList;
import java.util.List;

/* 2. Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload».
Нужно с ней выполнить следующие манипуляции:
2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
2.2. Определить, какой элемент в коллекции находится на первом месте.
Если мы получили пустую коллекцию, то пусть возвращается 0;
2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0; */
public class Main {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");
        
        long count = collection.stream().filter(s -> s.equals("High")).count();
        
        String firstElement = collection.stream().findFirst().orElse("0");
        
        String lastElement = collection.stream().reduce((a, b) -> b).orElse("0");
        
        System.out.println("Объект \"High\" встречается в коллекции: " + count + " раз");
        System.out.println("Первый элемент в коллекции: " + firstElement);
        System.out.println("Последний элемент в коллекции: " + lastElement);
    }
}
