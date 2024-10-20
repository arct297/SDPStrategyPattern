public class DiscountFareStrategy implements FareStrategy {
    private static final double RATE_PER_KM = 0.80;
    private static final double RATE_PER_MIN = 0.20;

    @Override
    public double calculateFare(double distance, double duration) {
        return (distance * RATE_PER_KM) + (duration * RATE_PER_MIN);
    }
}
