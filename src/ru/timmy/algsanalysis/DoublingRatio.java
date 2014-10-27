package ru.timmy.algsanalysis;

import ru.timmy.common.StdOut;
import ru.timmy.common.StdRandom;
import ru.timmy.common.Stopwatch;

/**
 * Created by tflomin on 27.10.2014.
 *
 */
public class DoublingRatio {
    // This class should not be instantiated.
    private DoublingRatio() {
    }

    /**
     * Returns the amount of time to call <tt>ThreeSum.count()</tt> with <em>N</em>
     * random 6-digit integers.
     *
     * @param N the number of integers
     * @return amount of time (in seconds) to call <tt>ThreeSum.count()</tt>
     * with <em>N</em> random 6-digit integers
     */
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call <tt>ThreeSum.count()</tt>
     * for arrays of size 250, 500, 1000, 2000, and so forth, along
     * with ratios of running times between successive array sizes.
     */
    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f %5.1f\n", N, time, time / prev);
            prev = time;
        }
    }
}
