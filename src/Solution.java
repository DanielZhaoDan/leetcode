import models.*;

import java.util.*;
import java.util.concurrent.Semaphore;

public class Solution {

    public int reversePairs(int[] nums) {
        int[] sorted = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            sorted[i] = nums[i];
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        BIT bit = new BIT(nums.length);
        int res = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            res += bit.query(nums[i] - 1);
            bit.update(nums[i], 1);
        }
        return res;

    }

    class BIT {
        int[] nums;
        int n;

        public BIT(int n) {
            this.n = n;
            nums = new int[n+1];
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        public void update(int idx, int v) {
            for (int i = idx; i <= n; i += lowbit(i)) {
                nums[i] += v;
            }
        }

        public int query(int r) {
            int res = 0;
            for (int i = r; i > 0; i -= lowbit(i)) {
                res += nums[i];
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{5, 5, 3, 2, 6};
        int[][] nums3 = {{1, 2, 3}, {4, 5, 6}};
        TreeNode node = generateTreeNode();
        Object o = s.reversePairs(nums1);
        utils.printObject(o);
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
