public class Park {
    
    public static class Attraction {
        String name;
        String timeOfWork;
        String price;
        
        public Attraction(String name, String timeOfWork, String price) {
            this.name = name;
            this.timeOfWork = timeOfWork;
            this.price = price;
        }
        
        public void info() {
            System.out.println(name + "\n" + timeOfWork + "\n" + price);
        }
    }
}
