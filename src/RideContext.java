public class RideContext {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.00;

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public double calculateFare(double distance, double duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative.");
        }

        double fare = fareStrategy.calculateFare(distance, duration);
        return Math.max(fare, MINIMUM_FARE);
    }

    public void autoSelectStrategy(double distance, boolean isPeakHour) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be non-negative.");
        }

        if (isPeakHour) {
            setFareStrategy(new SurgeFareStrategy());
        } else if (distance > 50) { // If long ride, then discount
            setFareStrategy(new DiscountFareStrategy());
        } else {
            setFareStrategy(new RegularFareStrategy());
        }
    }
}
