package Lab5;

import Lab5.Student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class StudentsArrayFactory {

    private static Random random = new Random();

    private static String[] Names = {
            "Andriy",
            "Dmytro", "Fedir",
            "Mykola", "Artem",
            "Nadiya", "Oksana"
    };
    private static String[] Surnames = {
            "Vann",
            "Huba", "Galey",
            "Dovzhenko", "Zherdev"
    };


    public static Student[] init20() {

        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            String firstName = initFirstName();
            String secondName = initSecondName();
            Faculty faculty = initFaculty();
            int course = initCourse();
            boolean isBudget = initTypeOfEducation();

            students[i] = new Student(firstName, secondName, faculty, course, isBudget);
        }
        return students;
    }

    private static String initFirstName() {
        return Names[random.nextInt(Names.length)];
    }

    private static String initSecondName() {
        return Surnames[random.nextInt(Surnames.length)];
    }

    private static Faculty initFaculty()
    {
        Faculty[] faculties = Faculty.values();
        return faculties[random.nextInt(faculties.length)];
    }

    private static boolean initTypeOfEducation()
    {
       return random.nextBoolean();
    }

    private static int initCourse() {
        return random.nextInt(4) + 1;
    }
}
