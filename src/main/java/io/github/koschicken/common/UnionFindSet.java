package io.github.koschicken.common;

public class UnionFindSet {
    private final int[] parents;

    /**
     * 初始化时，一个元素一个分组
     */
    public UnionFindSet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be >= 1");
        }
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parents[p1] = p2;
    }

    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    private void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
