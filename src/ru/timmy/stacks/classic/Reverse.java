package ru.timmy.stacks.classic;

import ru.timmy.common.StdIn;
import ru.timmy.common.StdOut;

/**
 * Created by tflomin on 30.09.2014.
 *
 */
public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack;
        stack = new Stack<Integer>();
        int i = 0;
        while (/*!StdIn.isEmpty()*/i != -123) {
            i = StdIn.readInt();
            stack.push(i);
        }
        for (int j : stack)
            StdOut.println(j);
    }
}
