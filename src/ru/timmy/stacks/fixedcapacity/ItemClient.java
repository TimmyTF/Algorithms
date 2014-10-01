package ru.timmy.stacks.fixedcapacity;

import ru.timmy.common.StdIn;
import ru.timmy.common.StdOut;

/**
 * Created by tflomin on 01.10.2014.
 *
 */
public class ItemClient {
    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
