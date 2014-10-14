package ru.timmy.adt.queues.vialist;

import ru.timmy.adt.common.StdIn;
import ru.timmy.adt.common.StdOut;

import java.util.Iterator;

/**
 * Created by tflomin on 13.10.2014.
 *
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return first == null; // Or: N == 0
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node {
        Item item;
        Node next;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue");
    }
}
