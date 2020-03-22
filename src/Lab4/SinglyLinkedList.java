package Lab4;

public class SinglyLinkedList {

    public int length;
    private Node root;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Student[] arr) {
        for (Student st : arr)
            add(st);
    }

    public Student get(int index) {
        Node n = root;
        for (; index > 0; index--)
            n = n.next;
        return n.data;
    }

    public void set(int index, Student st) {
        Node n = root;
        for (; index > 0; index--)
            n = n.next;
        n.data = st;
    }

    public void add(Student st) {
        if (root == null)
            root = new Node(st);
        else
            insert(root, st);
        length++;
    }

    public void print() {
        Node n = root;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public Node getRoot() {
        return root;
    }

    private void insert(Node n, Student st) {
        if (n.next != null)
            insert(n.next, st);
        else
            n.next = new Node(st);
    }

    private static class Node {
        public Node next;
        public Student data;

        private Node(Student st) {
            data = st;
        }
    }
}
