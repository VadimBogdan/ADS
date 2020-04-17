package Lab5;

enum Faculty {
    CS, SE, AI, HCI
}

public class Student {
    public String firstName;
    private String secondName;
    public Faculty faculty;
    public int course;
    public boolean isBudget;

    /**
     * @param course unsigned integer
     */
    public Student(
            String firstName,
            String secondName,
            Faculty faculty,
            int course,
            boolean isBudget)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.course = course;
        this.faculty = faculty;
        this.isBudget = isBudget;
    }

    @Override
    public String toString() {
        return String.format("%1$s %2$s | Faculty: %3$s | Course: %4$d | Type of education: "+educationType(isBudget),
                firstName, secondName, faculty, course);
    }

    public String educationType(boolean isBudget) {
        return isBudget ? "financed by government" : "self-funded";
    }

    public String getSecondName() {
        return secondName;
    }
}
