package models;

public class Node {

    public int data;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.data = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.data = val;
        this.prev = prev;
        this.child = child;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
