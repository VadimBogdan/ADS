package Lab4;

public class Student {
    public String firstName;
    public String secondName;
    public String group;
    public double avgRating;
    public int missedClasses;

    public Student(String firstName, String secondName,
                   String group, double avgRating, int missedClasses) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.group = group;
        this.avgRating = avgRating;
        this.missedClasses = missedClasses;
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$s | Group: %3$s | Avg. rating: %4$.1f | Classes missed: %5$d",
                firstName, secondName, group, avgRating, missedClasses);
    }
}
