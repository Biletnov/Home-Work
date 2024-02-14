import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class PhoneBook {
//    private Map<String, List<String>> phoneNumbers;
//
//    public PhoneBook() {
//        phoneNumbers = new HashMap<>();
//    }
//
//    public void add(String lastName, String phoneNumber) {
//        for (Map.Entry<String, List<String>> entry : phoneNumbers.entrySet()) {
//            if (entry.getValue().contains(phoneNumber)) {
//                System.out.println("Номер телефона уже принадлежит " + entry.getKey());
//                return;
//            }
//        }
//        if (!phoneNumbers.containsKey(lastName)) {
//            phoneNumbers.put(lastName, new ArrayList<>());
//        }
//        phoneNumbers.get(lastName).add(phoneNumber);
//    }
//
//    public List<String> get(String lastName) {
//        return phoneNumbers.get(lastName);
//    }
//}

public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }
    
    public void add(String lastName, String phoneNumber) {
        boolean phoneNumberExists = phoneBook.values().stream()
                .anyMatch(numbers -> numbers.contains(phoneNumber));
        
        if (phoneNumberExists) {
            System.out.println("Номер телефона уже записан");
        } else {
            phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
        }
    }
    
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
}