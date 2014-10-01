package ru.timmy.stacks.fixedcapacity;

/**
 * Created by tflomin on 01.10.2014.
 *
 */
public class FixedCapacityStack<Item> {
    private Item[] a;  // stack entries
    private int N;  // size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}
