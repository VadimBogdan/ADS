package Lab5;

import Lab5.Student;
import Lab5.StudentsArrayFactory;


public class Main {
    public static void main(String[] args) {
        // - Level 1
        Student[] students = StudentsArrayFactory.init20();
        orderByCourse(students);
        show(students);

        int count = find(students);
        System.out.println(count);

        // - Level 2
        BinarySearchTree bst = new BinarySearchTree();
        for (Student s : students)
            bst.insert(s);
        Student student = bst.find("Vann");
        System.out.println(student);

        // - Level 3
        BSTRandomize bstr = new BSTRandomize();
        for (Student s : students)
            bstr.insert(s);
        Student student_level_3 = bstr.find("Vann");
        System.out.println(student_level_3);
    }

    public static void show(Student[] students) {
        for (Student st : students)
            System.out.println(st);
        System.out.print("\n\n");
    }

    public static int find(Student[] students) {

        int count = 0;
        for (Student s : students) {
            if (s.course == 3 && !s.isBudget && s.faculty == Faculty.CS)
                ++count;
        }
        return count;
    }

    public static void orderByCourse(Student[] students) {
        for (int gap = (students.length / 2); gap > 0; gap /= 2) {

            for (int i = gap; i < students.length; i++) {
                Student temp = students[i];
                int j;
                for (j = i; j >= gap && students[j - gap].course > temp.course; j -= gap) {
                    students[j] = students[j - gap];
                }
                students[j] = temp;
            }
        }
    }
}
