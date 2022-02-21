import models.*;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums1 = {{0,1},{1,2},{2,3}};
        int[][] nums2 = {{0,4},{1,2},{3,1},{3,4}};
        char[][] input = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        Object o = s.friendRequests(5, nums1, nums2);
        utils.printObject("");
    }

    public static ListNode generateList() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(6);

        return head;
    }

    public static TreeNode generateTreeNode() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        return root;
    }

    public static NNode generateNNode() {
        NNode root = new NNode(1);
        root.left = new NNode(2);
        root.right = new NNode(3);

        root.left.left = new NNode(4);
        root.left.right = new NNode(5);

        root.right.left = new NNode(6);
        root.right.right = new NNode(7);

        return root;
    }
}
