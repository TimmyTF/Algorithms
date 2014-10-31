package ru.timmy.adt.stacks.repetition;

import java.util.Iterator;

/**
 * Created by tflomin on 31.10.2014.
 *
 */
public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;

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

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {
			// don't implement
		}
	}
}
