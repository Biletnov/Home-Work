package exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
// Как только пользователь введет пустую строку - программа должна прекратить приём данных от
// пользователя и вывести в консоль логины, начинающиеся на букву f (строчную).
public class Main {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите логины (для завершения введите пустую строку):");
        
        while (true) {
            String login = scanner.nextLine();
            
            if (login.isEmpty()) {
                break;
            }
            
            logins.add(login);
        }
        
        System.out.println("Логины, начинающиеся на букву 'f':");
        logins.stream()
                .filter(login -> login.startsWith("f"))
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
