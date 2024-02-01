package Exercise2;

public class Circle extends Figure {
    private double radius;
    
    protected Circle(String name, String figureColor, String borderColor, double radius) {
        super(name, figureColor, borderColor);
        this.radius = radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
