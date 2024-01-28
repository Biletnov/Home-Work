public class Park {
    private static Attraction[] attractions;
    private static int attractionsCount;
    
    public Park(int count) {
        attractions = new Attraction[count];
        attractionsCount = 0;
    }
    
    public static void addAttraction(Attraction attraction) {
        if (attractionsCount < attractions.length) {
            attractions[attractionsCount] = attraction;
            attractionsCount++;
        }
    }
    
    public static void infoAttr() {
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                System.out.println(attraction.getName() + "\n" + attraction.timeOfWork + "\n" + attraction.cost);
            }
        }
    }
    
    public class Attraction {
        private String name;
        private String timeOfWork;
        private double cost;
        
        public Attraction(String name, String timeOfWork, double cost) {
            this.name = name;
            this.timeOfWork = timeOfWork;
            this.cost = cost;
        }
        
        public void info() {
            System.out.println(name + "\n" + timeOfWork + "\n" + cost);
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
        
        public double getCost() {
            return cost;
        }
        
        public void setCost(double cost) {
            this.cost = cost;
        }
    }
}
