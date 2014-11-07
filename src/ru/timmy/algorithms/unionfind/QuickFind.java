package ru.timmy.algorithms.unionfind;

/**
 * Created by tflomin on 06.11.2014.
 *
 */
public class QuickFind extends UF {
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pId)
                id[i] = qId;
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }
}
