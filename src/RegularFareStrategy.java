public class RegularFareStrategy implements FareStrategy {
    private static final double RATE_PER_KM = 1.00;
    private static final double RATE_PER_MIN = 0.25;

    @Override
    public double calculateFare(double distance, double duration) {
        return (distance * RATE_PER_KM) + (duration * RATE_PER_MIN);
    }
}
