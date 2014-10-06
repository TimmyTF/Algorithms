package ru.timmy.stacks.fixedcapacity;

import java.util.Iterator;

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

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
            // interleaving iteration with operations that modify the data structure is
            // best avoided, that's why this method implementation is empty;
        }
    }
}
