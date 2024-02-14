import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
   Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
   Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)
   
   Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
   В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
   номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
   (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны. */
public class Main {
    public static void main(String[] args) {
        String[] array = {"Апельсин", "Яблоко", "Ананас", "Мандарин", "Банан", "Дыня",
                "Арбуз", "Груша", "Персик", "Апельсин", "Яблоко", "Ананас",
                "Арбуз", "Апельсин", "Мандарин", "Виноград", "Банан", "Дыня"};
        HashSet<String> uniqueFruit = new HashSet<>();
        HashMap<String, Integer> wordCount = new HashMap<>();
        Collections.addAll(uniqueFruit, array);
        for (String word : array) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("Уникальные слова: " + uniqueFruit);
        System.out.println("Количество каждого слова: " + wordCount);
        
        //PhoneBook
        PhoneBook phoneBook = new PhoneBook();
        //Добавление номеров
        phoneBook.add("Иванов", "9898212");
        phoneBook.add("Петров", "4840293");
        phoneBook.add("Сидоров", "21375869");
        phoneBook.add("Андреев", "4840293");  //Добавляет уже записанный номер
        phoneBook.add("Иванов", "99099090");
        
        System.out.println("Иванов " + phoneBook.get("Иванов")); //Выводит все номера фамилии
        System.out.println("Петров " + phoneBook.get("Петров"));
        System.out.println("Андреев " + phoneBook.get("Андреев")); // Проверка добавился ли повторяющийся номер
        phoneBook.add("Андреев", "8383838");
        System.out.println("Андреев " + phoneBook.get("Андреев"));
    }
}