package Exercise1;

public class Dog extends Animal {
    private static int counter;
    
    public Dog(String name) {
        super(name);
        counter++;
    }
    
    public static void countInfo() {
        System.out.println(Dog.counter);
    }
    
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(getName() + " - \"сорян, я столько не пробегу...\"");
        } else {
            System.out.println(getName() + " пробежал " + distance + "м.");
        }
    }
    
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(getName() + " - \"я столько не проплыву...\"");
        } else {
            System.out.println(getName() + " проплыл " + distance + "м.");
        }
    }
}
