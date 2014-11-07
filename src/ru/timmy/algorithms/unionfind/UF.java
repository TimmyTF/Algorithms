package ru.timmy.algorithms.unionfind;

/**
 * Created by tflomin on 06.11.2014.
 *
 */
public abstract class UF {
    protected int[] id;
    protected int count;

    public UF() {
        //
    }

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public abstract void union(int p, int q);

    /**
     * Finds component to which site 'p' belongs.
     * @param p id of the site.
     * @return The same integer for every site in each connected component.
     */
    public abstract int find(int p);

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
