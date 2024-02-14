public class Main {
    public static void main(String[] args) {
        // Создаем несколько фруктов
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        
        // Создаем коробки для фруктов
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        
        // Добавляем фрукты в коробки
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox2.addFruit(apple1); // можно добавить одинаковые фрукты в разные коробки
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);
        
        // Выводим вес коробок
        System.out.println("Вес appleBox1: " + appleBox1.getWeight()); // ожидаемый результат: 2.0
        System.out.println("Вес appleBox2: " + appleBox2.getWeight()); // ожидаемый результат: 1.0
        System.out.println("Вес orangeBox: " + orangeBox.getWeight()); // ожидаемый результат: 3.0
        
        // Сравниваем коробки
        System.out.println("Сравнение appleBox1 и appleBox2: " + appleBox1.compare(appleBox2)); // ожидаемый результат: false
        System.out.println("Сравнение appleBox1 и orangeBox: " + appleBox1.compare(orangeBox)); // ожидаемый результат: true
        
        // Пересыпаем фрукты из одной коробки в другую
        appleBox1.transferFruits(appleBox2);
        
        // Выводим вес коробок после пересыпания
        System.out.println("Вес appleBox1 после пересыпания: " + appleBox1.getWeight()); // ожидаемый результат: 0.0
        System.out.println("Вес appleBox2 после пересыпания: " + appleBox2.getWeight()); // ожидаемый результат: 3.0
    }
}
