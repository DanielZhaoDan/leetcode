package models;

public
class UnionFind {
    public int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }


    public int findParent(int index) {
        if (parent[index] == index) {
            return index;
        }
        // path compression
        parent[index] = findParent(parent[index]);
        return parent[index];
    }

    public boolean union(int i, int j) {
        int parentI = findParent(i);
        int parentJ = findParent(j);

        if (parentI == parentJ) {
            return false;
        }
        parent[parentI] = parentJ;
        return true;
    }
}
