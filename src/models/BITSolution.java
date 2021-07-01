package models;

import java.util.Arrays;

public class BITSolution {

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
}
