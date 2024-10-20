public class SurgeFareStrategy implements FareStrategy {
    private static final double RATE_PER_KM = 2.00;
    private static final double RATE_PER_MIN = 0.50;

    @Override
    public double calculateFare(double distance, double duration) {
        return (distance * RATE_PER_KM) + (duration * RATE_PER_MIN);
    }
}
