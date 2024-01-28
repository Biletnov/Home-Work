package Exercise2;

public class Circle implements Shape, Fillable, Borderable {
    private double radius;
    private String fillColor;
    private String borderColor;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }
    
    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
    
    public void printCharacteristics() {
        System.out.println("Circle:");
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
        System.out.println("Fill color: " + fillColor);
        System.out.println("Border color: " + borderColor);
    }
}
