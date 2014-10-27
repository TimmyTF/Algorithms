package ru.timmy.adt.queues;

import ru.timmy.common.In;

/**
 * Created by tflomin on 30.09.2014.
 *
 */
public class SampleClient {
    public static void main(String[] args) {
        int[] arr = readInts("D:\\misc-projects\\Algorithms\\src\\ru\\timmy\\queues\\numbers.txt");
        for (int i : arr)
            System.out.println("next: " + i);
    }

    public static int[] readInts(String name) {
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty())
            q.enqueue(in.readInt());
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }
}
