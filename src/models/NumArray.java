package models;

// Segment Tree
public class NumArray {

    int[] data;
    int[] tree;

    private int merge(int a, int b) {
        return a + b;
    }

    public NumArray(int[] data) {
        this.data = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        this.tree = new int[4 * data.length];

        buildTree(0, 0, data.length - 1);
    }

    private void buildTree(int treeIndex, int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int treeLeft = 2 * treeIndex + 1;
        int treeRight = treeLeft + 1;
        int dataMid = l + (r - l) / 2;

        buildTree(treeLeft, l, dataMid);
        buildTree(treeRight, dataMid + 1, r);

        tree[treeIndex] = merge(tree[treeLeft], tree[treeRight]);
    }

    public void update(int index, int val) {
        update(0, 0, data.length - 1, index, val);
    }

    private void update(int treeIndex, int l, int r, int index, int value) {
        if (l == r) {
            tree[treeIndex] = value;
            return;
        }

        int treeLeft = 2 * treeIndex + 1;
        int treeRight = treeLeft + 1;
        int dataMid = l + (r - l) / 2;

        if (index <= dataMid) {
            update(treeLeft, l, dataMid, index, value);
        } else {
            update(treeRight, dataMid + 1, r, index, value);
        }
        ;

        tree[treeIndex] = merge(tree[treeLeft], tree[treeRight]);
    }

    public int sumRange(int i, int j) {
        return query(0, 0, data.length - 1, i, j);
    }

    private int query(int treeIndex, int l, int r, int i, int j) {
        if (l == r) {
            return tree[treeIndex];
        }

        int treeLeft = 2 * treeIndex + 1;
        int treeRight = treeLeft + 1;
        int dataMid = l + (r - l) / 2;

        if (j <= dataMid) {
            return query(treeLeft, l, dataMid, i, j);
        } else if (i > dataMid) {
            return query(treeRight, dataMid + 1, r, i, j);
        } else {
            return merge(query(treeLeft, l, dataMid, i, dataMid), query(treeRight, dataMid + 1, r, dataMid + 1, j));
        }
    }
}
