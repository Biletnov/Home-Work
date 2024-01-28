package Exercise2;

public class Rectangle implements Shape, Fillable, Borderable {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
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
        System.out.println("Rectangle:");
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
        System.out.println("Fill color: " + fillColor);
        System.out.println("Border color: " + borderColor);
    }
}
