package ru.timmy.adt.stacks.vialist;

import ru.timmy.common.StdIn;
import ru.timmy.common.StdOut;

import java.util.Iterator;

/**
 * Created by tflomin on 13.10.2014.
 *
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
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

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
