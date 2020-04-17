package Lab3;

public class Student {
    public String secondName;
    public String firstName;
    public String arrivedFrom;
    /**
     * course is unsigned integer.
     */
    public int course;
    public int id;

    public Student(String secondName, String firstName, String arrivedFrom
            , int course, int id) {
        if (course < 0) {
            throw new IllegalArgumentException("Course cannot be negative number!");
        }
        this.secondName = secondName;
        this.firstName = firstName;
        this.arrivedFrom = arrivedFrom;
        this.course = course;
        this.id = id;
    }

    public void setCourse(int course) {
        if (course < 0) {
            throw new IllegalArgumentException("Course cannot be negative number!");
        }
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Fullname: %1$s %2$s, %3$d course, %4$d Id. From %5$s",
                firstName, secondName, course, id, arrivedFrom);
    }
}
