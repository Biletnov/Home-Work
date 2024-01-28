package Exercise1;

public class Bowl {
    private static int food;
    
    public Bowl(int food) {
        this.food = food;
    }
    
    public void addFood(int amount) {
        food += amount;
    }
    
    public static void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            System.out.println("В миске недостаточно еды.");
        }
    }
    
    public static int getFood() {
        return food;
    }
}
