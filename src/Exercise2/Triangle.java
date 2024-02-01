package Exercise2;

class Triangle extends Figure {
    
    private double side1;
    private double side2;
    private double side3;
    
    protected Triangle(String name, String figureColor, String borderColor, double side1, double side2, double side3) {
        super(name, figureColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) *
                (halfPerimeter - side2) * (halfPerimeter - side3));
    }
}