package ru.timmy.adt.bags;

import ru.timmy.adt.common.StdIn;
import ru.timmy.adt.common.StdOut;

/**
 * Created by tflomin on 29.09.2014.
 *
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();
        double d = 0.0;
        while (/*!StdIn.isEmpty()*/d != -123.4) {
            d = StdIn.readDouble();
            numbers.add(d);
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum / N;
        sum = 0.0;
        for (double x : numbers)
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
