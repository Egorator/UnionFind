package com.company;

public class UnionFind {

    private int[] id;
    private int[] componentSize;
    private int[] max;

    private enum Status {
        SUCCESS,
        OUT_OF_RANGE,
        ALREADY_CONNECTED
    }

    public UnionFind(int N) {
        id = new int[N];
        componentSize = new int[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            componentSize[i] = 1;
            max[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public int find(int i) {
        return max[getRoot(i)];
    }

    public void callback(int firstRoot, int secondRoot) {
        int maxAll;
        if(max[firstRoot] > max[secondRoot])
            maxAll = max[firstRoot];
        else
            maxAll = max[secondRoot];
        max[firstRoot] = maxAll;
        max[secondRoot] = maxAll;
    }

    public Status union(int first, int second) {
        if ((first < 0) || (first >= id.length)
                || (second < 0) || (second >= id.length))
            return Status.OUT_OF_RANGE;

        int firstRoot = getRoot(first);
        int secondRoot = getRoot(second);
        if (firstRoot == secondRoot)
            return Status.ALREADY_CONNECTED;

        callback(firstRoot, secondRoot);

        int sizeOfFirst = componentSize[firstRoot];//[first]
        int sizeOfSecond = componentSize[secondRoot];//[second]
        connect(firstRoot, secondRoot);
        int newRoot = getRoot(first);
        assert newRoot == getRoot(second);
        assert componentSize[newRoot] == sizeOfFirst + sizeOfSecond;
        return Status.SUCCESS;
    }

    private int getRoot(int i) {
        assert (i >= 0) && (i < id.length);
        while (i != id[i])
            i = id[i];
        assert (i >= 0) && (i < id.length);
        return i;
    }

    private void connect(int first, int second) {
        assert first != second;
        if (componentSize[first] < componentSize[second])
            mergeFirstIntoSecond(first, second);
        else
            mergeFirstIntoSecond(second, first);
    }

    private void mergeFirstIntoSecond(int first, int second) {
        id[first] = second;
        componentSize[second] += componentSize[first];
    }
}
