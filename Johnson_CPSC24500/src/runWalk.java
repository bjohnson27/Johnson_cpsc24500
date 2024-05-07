import java.util.Date;

public class runWalk extends Exercise {
    private boolean isRunning;
    private double distance; // New field for distance

    public runWalk(String name, Date date, double duration, String comment, boolean isRunning, double distance) {
        super(name, date, duration, comment);
        this.isRunning = isRunning;
        this.distance = distance;
    }

    // Getter and setter methods for distance
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String getType() {
        return "Run/Walk";
    }

    @Override
    public double getCaloriesBurned() {
        // Calculate calories burned for Run/Walk exercise based on distance
        return (getDuration() > 0) ? (10 * distance) / getDuration() : 0;
    }
}
