package Exercise2;

public abstract class Figure implements FigureCalculation {
    private final String NAME;
    private final String FIGURE_COLOR;
    private final String BORDER_COLOR;
    
    protected Figure(String name, String figureColor, String borderColor) {
        NAME = name;
        FIGURE_COLOR = figureColor;
        BORDER_COLOR = borderColor;
    }
    
    public String toString() {
        return (NAME + "\n" + "цвет фигуры: " + FIGURE_COLOR + "\n" + "цвет границы: " + BORDER_COLOR);
    }
}
