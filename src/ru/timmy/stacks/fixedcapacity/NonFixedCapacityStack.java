package ru.timmy.stacks.fixedcapacity;

/**
 * Created by tflomin on 01.10.2014.
 *
 */
public class NonFixedCapacityStack<Item> {
    private Item[] a;  // stack entries
    private int N;  // size

    public NonFixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    /** Remove item from top of stack.
     *
     * @return top element of the stack
     */
    public Item pop() {
        Item item = a[--N];
        a[N] = null; // Avoid loitering (see text).
        if (N > 0 && N == a.length/4)
            resize(a.length/2);
        return item;
    }

    /** Move stack of size N <= max to a new array of size max.
     *
     * @param max new size of this stack
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }
}
