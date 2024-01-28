package Exercise1;

public class Animal {
    private String name;
    private static int counter;
    
    public Animal(String name) {
        this.name = name;
        counter++;
    }
    
    public static void countInfo() {
        System.out.println(Animal.counter);
    }
    
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м.");
    }
    
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м.");
    }
    
    public String getName() {
        return name;
    }
}
