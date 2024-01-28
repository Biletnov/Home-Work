package Exercise1;

public class Cat extends Animal {
    private static int counter;
    private boolean fullness;
    
    public Cat(String name) {
        super(name);
        fullness = false;
        counter++;
    }
    
    public static void countInfo() {
        System.out.println(Cat.counter);
    }
    
    public void feeding() {
        if ((!fullness) && (Bowl.getFood() > 10)) {
            Bowl.decreaseFood(10);
            fullness = true;
        } else {
            System.out.println(getName() + " - \" мне не хватило еды...(((\"");
        }
    }
    
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(getName() + " - \"ты что смерти моей хочешь...?\"");
        } else {
            System.out.println(getName() + " пробежал " + distance + "м.");
        }
    }
    
    public void swim(int distance) {
        System.out.println(getName() + " - \"сам плыви, я не умею плавать...\"");
    }
    
    public void isFull() {
        System.out.println(fullness);
    }
}
