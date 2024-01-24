public class Park {
    public static class Attraction {
        String name;
        String timeOfWork;
        String price;
        
        public void info(String name, String timeOfWork, String price) {
            this.name = name;
            this.timeOfWork = timeOfWork;
            this.price = price;
            System.out.println(name + "\n" + timeOfWork + "\n" + price);
        }
    }
}
