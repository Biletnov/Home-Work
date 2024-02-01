package Exercise2;

public class Main {
    public static void main(String[] args) {
        
        Circle circle = new Circle("Круг", "синий", "красный", 20);
        System.out.println(circle);
        System.out.println("----------------------------------");
        Rectangle rectangle = new Rectangle("Прямоугольник", "зелёный", "чёрный",
                15, 55);
        System.out.println(rectangle);
        System.out.println("----------------------------------");
        Triangle triangle = new Triangle("Треугольник", "чёрный", "жёлтый",
                15, 25, 15);
        System.out.println(triangle);
    }
}
