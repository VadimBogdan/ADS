package Lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class StudentsArray {

    private static Random random = new Random();
    private static String[] Names = {"Andriy", "Dmytro", "Fedir",
            "Mykola", "Artem", "Nadiya", "Oksana"};
    private static String[] Surnames = {"Vann", "Huba", "Galey", "Dovzhenko", "Zherdev"};
    private static String[] Groups = {"PI-216", "PI-217", "PI-218", "PI-219", "PI-220"};

    public static Student[] init10() {
        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            String firstName = initFirstName();
            String secondName = initSecondName();
            String group = initGroup();
            double avgRating = initAvgRating();
            int missedClasses = initMissedClasses();

            students[i] = new Student(firstName, secondName, group, avgRating, missedClasses);
        }
        return students;
    }

    private static String initFirstName() {
        return Names[random.nextInt(Names.length)];
    }

    private static String initSecondName() {
        return Surnames[random.nextInt(Surnames.length)];
    }

    private static String initGroup() {
        return Groups[random.nextInt(Groups.length)];
    }

    private static double initAvgRating() {
        BigDecimal bigDecimal = BigDecimal.valueOf(random.nextDouble() * 100);
        return bigDecimal.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    private static int initMissedClasses() {
        return random.nextInt(26);
    }
}
