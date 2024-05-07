import java.util.Date;

public class rockClimbing extends Exercise {
    private double wallHeight;
    private int timesScaled;

    public rockClimbing(String name, Date date, double duration, String comment, double wallHeight, int timesScaled) {
        super(name, date, duration, comment);
        this.wallHeight = wallHeight;
        this.timesScaled = timesScaled;
    }

    // Getter and setter methods for wallHeight
    public double getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    // Getter and setter methods for timesScaled
    public int getTimesScaled() {
        return timesScaled;
    }

    public void setTimesScaled(int timesScaled) {
        this.timesScaled = timesScaled;
    }

    @Override
    public String getType() {
        return "Rock Climbing";
    }

    @Override
    public double getCaloriesBurned() {
        // Calculate calories burned for Rock Climbing exercise
        return (getDuration() > 0) ? (wallHeight * timesScaled * 100) / getDuration() : 0;
    }
}
