package Lab5;

public class BSTRandomize {
    private static class Node {
        Student student;
        Node left;
        Node right;
        int countOfNodes;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;
    public void insert(Student newStudent) {
        root = insertTree(root, newStudent);
}

    private Node insertTree(Node cur, Student newStudent) {
        if (cur == null) {
            Node newNode = new Node(newStudent);
            newNode.countOfNodes = 1;
            return newNode;
        }
        if (Math.random()*cur.countOfNodes < 1.0) {
            cur = insR(cur, newStudent);
        }
        else if (newStudent.getSecondName().compareToIgnoreCase(cur.student.getSecondName()) < 0) {
            cur.left = insertTree(cur.left, newStudent);
        }
        else {
            cur.right = insertTree(cur.right, newStudent);
        }
        cur.countOfNodes++;
        return cur;
    }

    private Node insR(Node cur, Student newStudent) {
        cur = insertRoot(cur, newStudent);
        cur.countOfNodes = cur.countOfNodes - 1;
        return cur;
    }

    private Node insertRoot(Node cur, Student newStudent) {
        if (cur == null) {
            Node node = new Node(newStudent);
            node.countOfNodes = 1;
            return node;
        }
        if (newStudent.getSecondName().compareTo(cur.student.getSecondName()) < 0) {
            cur.left = insertRoot(cur.left, newStudent);
            cur.countOfNodes = cur.countOfNodes - cur.left.countOfNodes;
            cur = rotationR(cur);
            cur.right.countOfNodes = count(cur.right);
        }
        else {
            cur.right = insertRoot(cur.right, newStudent);
            cur.countOfNodes = cur.countOfNodes - cur.right.countOfNodes;
            cur = rotationL(cur);
            cur.left.countOfNodes = count(cur.left);
        }
        cur.countOfNodes = count(cur);
        return cur;
    }

    private int count(Node cur) {
        if (cur.left != null) {
            if (cur.right != null)
                cur.countOfNodes = cur.left.countOfNodes + cur.right.countOfNodes;
            else
                cur.countOfNodes = cur.left.countOfNodes;
        } else if (cur.right != null)
            cur.countOfNodes = cur.right.countOfNodes;
        return ++cur.countOfNodes;
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
