package com.company;

public class UnionFind {

    private int[] id;
    private int[] sz;
    private int[] max;

    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int find(int i) {
        return max[root(i)];
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;
        if (sz[i] < sz[j]) weightingAndMaxFinding(i, j);
        else weightingAndMaxFinding(j, i);
    }

    private void weightingAndMaxFinding(int firstNum, int secondNum) {
        if (max[firstNum] > max[secondNum])
            max[secondNum] = max[firstNum];

        id[firstNum] = secondNum;
        sz[secondNum] += sz[firstNum];
    }
}
