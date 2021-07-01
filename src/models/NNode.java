package models;

public class NNode {

    public int val;
    public NNode left;
    public NNode right;
    public NNode next;

    public NNode() {
    }

    public NNode(int val) {
        this.val = val;
    }

    public NNode(int val, NNode left, NNode right, NNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
