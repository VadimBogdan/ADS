package Lab3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTreeLvl1 = new BinaryTree();
        binaryTreeLvl1.add(new Student("M", "T", "Kyiv", 5, 789987));
        binaryTreeLvl1.add(new Student("M1", "T1", "Odessa", 2, 123321));
        binaryTreeLvl1.add(new Student("M2", "T2", "Lviv", 2, 213312));
        binaryTreeLvl1.add(new Student("M3", "T3", "Kharkiv", 1, 321123));
        binaryTreeLvl1.add(new Student("M4", "T4", "Kharkiv", 1, 879978));

        binaryTreeLvl1.print();

        // - Level 2
        BinaryTree binaryTreeLvl2 = new BinaryTree();
        binaryTreeLvl2.add(new Student("R", "T", "Kyiv", 5, 789987));
        binaryTreeLvl2.add(new Student("R1", "T1", "Odessa", 2, 123321));
        binaryTreeLvl2.add(new Student("R2", "T2", "Lviv", 2, 213312));
        binaryTreeLvl2.add(new Student("R3", "T3", "Lutsk", 1, 321123));
        binaryTreeLvl2.add(new Student("R4", "T4", "Kharkiv", 1, 879978));

        binaryTreeLvl2.print();

        List<Student> list = binaryTreeLvl2.find(1, "Kharkiv");
        displayList(list);

        // - Level 3
        BinaryTree binaryTreeLvl3 = new BinaryTree();
        binaryTreeLvl3.add(new Student("R", "T", "Kyiv", 5, 789987));
        binaryTreeLvl3.add(new Student("R1", "T1", "Odessa", 2, 123321));
        binaryTreeLvl3.add(new Student("R2", "T2", "Lviv", 2, 213312));
        binaryTreeLvl3.add(new Student("M3", "T3", "Kharkiv", 1, 321123));
        binaryTreeLvl3.add(new Student("M4", "T4", "Kharkiv", 1, 879978));
        binaryTreeLvl3.add(new Student("MK5", "TN5", "Vinnytsia", 1, 567765));
        binaryTreeLvl3.add(new Student("MK6", "TN6", "Ternopil", 1, 657756));

        binaryTreeLvl3.print();

        binaryTreeLvl3.remove(1, "Ternopil");
        binaryTreeLvl3.print();
    }

    public static void displayList(List<Student> l) {
        System.out.print("\n\n");
        for (Student s : l) {
            System.out.println(s);
        }
    }
}
