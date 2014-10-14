package ru.timmy.adt.bags.vialist;

import java.util.Iterator;

/**
 * Created by tflomin on 13.10.2014.
 *
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            // interleaving iteration with operations that modify the data structure is
            // best avoided, that's why this method implementation is empty;
        }
    }

    private class Node {
        Item item;
        Node next;
    }
}
