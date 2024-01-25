public class Park {
    private int countAttraction;
    
    public Park(int countAttraction) {
        this.countAttraction = countAttraction;
    }
    
    public int getCountAttraction() {
        return countAttraction;
    }
    
    public void setCountAttraction(int countAttraction) {
        this.countAttraction = countAttraction;
    }
    
    public void addAttr() {
    }
    
    public static class Attraction {
        private String name;
        private String timeOfWork;
        private String price;
        
        public Attraction(String name, String timeOfWork, String price) {
            this.name = name;
            this.timeOfWork = timeOfWork;
            this.price = price;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getTimeOfWork() {
            return timeOfWork;
        }
        
        public void setTimeOfWork(String timeOfWork) {
            this.timeOfWork = timeOfWork;
        }
        
        public String getPrice() {
            return price;
        }
        
        public void setPrice(String price) {
            this.price = price;
        }
        
        public void info() {
            System.out.println(name + "\n" + timeOfWork + "\n" + price);
        }
    }
}
