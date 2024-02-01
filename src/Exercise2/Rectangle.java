package Exercise2;

public class Rectangle extends Figure {
    private double width;
    private double height;
    
    protected Rectangle(String name, String figureColor, String borderColor, double width, double height) {
        super(name, figureColor, borderColor);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    public void printCharacteristics() {
        System.out.println(toString());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    }
}
