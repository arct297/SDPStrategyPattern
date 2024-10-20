public class Main {
    public static void main(String[] args) {
        RideContext rideContext = new RideContext();

        System.out.println("Test for simple ride with short distance:");
        try {
            rideContext.autoSelectStrategy(10, false);
            double fare1 = rideContext.calculateFare(10, 15);
            System.out.println("Fare for regular time: $" + fare1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Test for invalid data:");
        try {
            rideContext.autoSelectStrategy(-5, false);
            double fare2 = rideContext.calculateFare(-5, 15);
            System.out.println("Fare for invalid distance: $" + fare2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Test for rush hour:");
        try {
            rideContext.autoSelectStrategy(20, true);
            double fare2 = rideContext.calculateFare(20, 25);
            System.out.println("Fare for surge pricing: $" + fare2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Test for invalid data:");
        try {
            rideContext.autoSelectStrategy(10, true);
            double fare3 = rideContext.calculateFare(10, -10);
            System.out.println("Fare for invalid duration: $" + fare3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Test for long distance:");
        try {
            rideContext.autoSelectStrategy(60, false);
            double fare3 = rideContext.calculateFare(60, 75);
            System.out.println("Fare for long distance: $" + fare3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Test for premium case:");
        try {
            rideContext.setFareStrategy(new PremiumFareStrategy());
            double fare4 = rideContext.calculateFare(15, 20);
            System.out.println("Fare for premium service: $" + fare4);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");
    }
}