import java.util.Date;

public class weightLifting extends Exercise {
    private double totalPounds;

    public weightLifting(String name, Date date, double duration, String comment, double totalPounds) {
        super(name, date, duration, comment);
        this.totalPounds = totalPounds;
    }

    // Getter and setter methods for totalPounds
    public double getTotalPounds() {
        return totalPounds;
    }

    public void setTotalPounds(double totalPounds) {
        this.totalPounds = totalPounds;
    }

    @Override
    public String getType() {
        return "Weightlifting";
    }

    @Override
    public double getCaloriesBurned() {
        // Calculate calories burned for Weightlifting exercise
        return (getDuration() > 0) ? (totalPounds * 0.05) / getDuration() : 0;
    }
}
