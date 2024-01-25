public class Park {
    
    public static class Attraction {
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
