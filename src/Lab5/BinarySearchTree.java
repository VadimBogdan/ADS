package Lab5;

public class BinarySearchTree {
    private static class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
        }
    }
    private Node root;
    public void insert(Student newStudent) {
        root = insertNode(root, newStudent);
    }

    private Node insertNode(Node cur, Student newStudent) {
        if (cur == null)
            return new Node(newStudent);
        if (newStudent.getSecondName().compareToIgnoreCase(cur.student.getSecondName()) < 0) {
            cur.left = insertNode(cur.left, newStudent);
            cur = rotationR(cur);
        }
        else {
            cur.right = insertNode(cur.right, newStudent);
            cur = rotationL(cur);
        }
        return cur;
    }

    private Node rotationR(Node cur) {
        Node temp = cur.left;
        cur.left = temp.right;
        temp.right = cur;
        cur = temp;
        return cur;
    }

    private Node rotationL(Node cur) {
        Node temp = cur.right;
        cur.right = temp.left;
        temp.left = cur;
        cur = temp;
        return cur;
    }

    public Student find(String key) {
        return findNode(root, key).student;
    }

    private Node findNode(Node cur, String key) {
        if (cur == null)
            return cur;
        if (cur.student.getSecondName().compareToIgnoreCase(key) > 0) {
            cur = findNode(cur.left, key);
        }
        else if (cur.student.getSecondName().compareToIgnoreCase(key) < 0) {
            cur = findNode(cur.right, key);
        }
        else
            return cur;
        return cur;
    }
}
