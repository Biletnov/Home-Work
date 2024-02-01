package Exercise2;

public abstract class Figure implements FigureCalculation {
    private String name;
    private String figureColor;
    private String borderColor;
    
    protected Figure(String name, String figureColor, String borderColor) {
        this.name = name;
        this.figureColor = figureColor;
        this.borderColor = borderColor;
    }
    
    public String toString() {
        return (name + "\n" + "цвет фигуры: " + figureColor + "\n" + "цвет границы: " + borderColor +
                "\nPerimeter: " + getPerimeter() + "\nArea: " + getPerimeter());
    }
}
