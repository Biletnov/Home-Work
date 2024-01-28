package Exercise2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        circle.setFillColor("Green");
        circle.setBorderColor("Red");
        circle.printCharacteristics();
        System.out.println("----------------------------------");
        Rectangle rectangle = new Rectangle(5, 23);
        rectangle.setFillColor("Yellow");
        rectangle.setBorderColor("Black");
        rectangle.printCharacteristics();
        System.out.println("----------------------------------");
        Triangle triangle = new Triangle(10, 5, 20);
        triangle.setFillColor("Orange");
        triangle.setBorderColor("White");
        triangle.printCharacteristics();
    }
}
