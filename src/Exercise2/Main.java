package Exercise2;

public class Main {
    public static void main(String[] args) {
        
        Circle circle = new Circle("Круг", "синий", "красный", 20);
        circle.printCharacteristics();
        System.out.println("----------------------------------");
        Rectangle rectangle = new Rectangle("Прямоугольник", "зелёный", "чёрный",
                15, 55);
        rectangle.printCharacteristics();
        System.out.println("----------------------------------");
        Triangle triangle = new Triangle("Треугольник", "чёрный", "жёлтый",
                15, 25, 15);
        triangle.printCharacteristics();
    }
}
