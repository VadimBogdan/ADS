package Lab4;

public class Main {
    public static void main(String[] args) {
        // - Level 1
        Student[] students = StudentsArray.init10();

        show(students);

        Sort.shellSort(students);

        show(students);

        // - Level 2
        SinglyLinkedList studentsSinglyLinkedList = new SinglyLinkedList(StudentsArray.init10());

        show(studentsSinglyLinkedList);

        Sort.bubbleSort(studentsSinglyLinkedList);

        show(studentsSinglyLinkedList);

        // - Level 3
        Student[] students1 = StudentsArray.init10();

        show(students1);

        Sort.TopDownMergeSort(students1, 0, students1.length - 1);

        show(students1);
    }

    public static void show(Student[] students) {
        for (Student st : students)
            System.out.println(st);
        System.out.print("\n\n");
    }

    public static void show(SinglyLinkedList students) {
        students.print();
        System.out.print("\n\n");
    }
}
