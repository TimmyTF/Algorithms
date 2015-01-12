package ru.timmy.algorithms.unionfind;

/**
 * Created by tflomin on 10.11.2014.
 *
 */
public class QuickUnion extends UF {
    @Override
    public void union(int p, int q) {
        int qRoot = find(q);
        int pRoot = find(p);
        if (pRoot == qRoot)
            return;

        id[pRoot] = qRoot;

        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
