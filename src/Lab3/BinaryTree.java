package Lab3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;

    public void add(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Attempt to add null ref");

        root = insert(student, root);
    }

    // FIXME: Level 2
    public List<Student> find(int withCourse, String notFrom) {
        List<Student> list = new ArrayList<>();

        postOrderList(root, list, withCourse, notFrom);
        return list;
    }

    // FIXME: Level 3
    public void remove(int withCourse, String notFrom) {
        // handle root el
        while (root != null && root.student.course == withCourse &&
                !root.student.arrivedFrom.contentEquals(notFrom)) {
            Student st = rightLeftmost(root.right);

            if (st == null) {
                root = root.left;
            } else if (st == root.right.student) {
                Node temp = root.left;
                root = root.right;
                root.left = temp;
            } else {
                root.student = st;
            }
        }
        if (root == null) return;

        // handle each sub-tree
        leftsubreeRemoveOp(root, withCourse, notFrom);
        rightsubtreeRemoveOp(root, withCourse, notFrom);
    }

    // FIXME: Level 3
    private void leftsubreeRemoveOp(Node n, int withCourse, String notFrom) {
        while (n.left != null && n.left.student.course == withCourse &&
                !n.left.student.arrivedFrom.contentEquals(notFrom)) {
            Student st = leftRightmost(n.left.left);

            if (st == null) {
                n.left = n.left.left;
            } else if (st == n.left.left.student) {
                Node temp = n.left.right;
                n.left = n.left.left;
                n.left.right = temp;
            } else {
                n.left.student = st;
            }
        }
        if (n.left == null) return;

        leftsubreeRemoveOp(n.left, withCourse, notFrom);
        rightsubtreeRemoveOp(n.left, withCourse, notFrom);
    }

    // FIXME: Level 3
    private void rightsubtreeRemoveOp(Node n, int withCourse, String notFrom) {
        while (n.right != null && n.right.student.course == withCourse &&
                !n.right.student.arrivedFrom.contentEquals(notFrom)) {
            Student st = rightLeftmost(n.right.right);

            if (st == null) {
                n.right = n.right.right;
            } else if (st == n.right.right.student) {
                Node temp = n.right.left;
                n.right = n.right.right;
                n.right.left = temp;
            } else {
                n.left.student = st;
            }
        }
        if (n.right == null) return;

        rightsubtreeRemoveOp(n.right, withCourse, notFrom);
        leftsubreeRemoveOp(n.right, withCourse, notFrom);
    }

    // FIXME: Level 3
    private Student rightLeftmost(Node n) {
        if (n == null) return null;
        if (n.left != null && n.left.left == null) {
            Student found = n.left.student;

            n.left = n.left.right;
            return found;
        }
        if (n.left == null) return n.student;
        return rightLeftmost(n.right);
    }

    // FIXME: Level 3
    private Student leftRightmost(Node n) {
        if (n == null) return null;
        if (n.right != null && n.right.right == null) {
            Student found = n.right.student;

            n.right = n.left.right;
            return found;
        }
        if (n.right == null) return n.student;
        return leftRightmost(n.right);
    }

    private Node insert(Student student, Node n) {
        if (n == null)
            return new Node(student);
        if (student.id < n.student.id) {
            n.left = insert(student, n.left);
        } else {
            n.right = insert(student, n.right);
        }
        return n;
    }

    private void postOrderPrint(Node n) {
        if (n != null) {
            postOrderPrint(n.left);
            postOrderPrint(n.right);
            System.out.println(n.student);
        }
    }

    // FIXME: Level 2
    private void postOrderList(Node n, List<Student> list, int c, String from) {
        if (n != null) {
            postOrderList(n.left, list, c, from);
            postOrderList(n.right, list, c, from);
            if (!n.student.arrivedFrom.contentEquals(from)
                    && n.student.course == c) {

                list.add(n.student);
            }
        }
    }

    public void print() {
        System.out.print("\n\n");
        postOrderPrint(root);
    }

    private static class Node {
        public Student student;
        public Node left;
        public Node right;

        private Node(Student student) {
            this.student = student;
        }
    }
}
