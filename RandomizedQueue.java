import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private Node current;


	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public RandomizedQueue() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return (first == null);
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}

		Node temp = first.next;
		int count = 1;

		while(temp != null) { // or last
			temp = temp.next;
			count++;
		}

		return count;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
			}

		Node n = new Node();
		n.item = item;
		n.next = null;
		n.prev = last;
		last.next = n;
		last = n;
	}

	public Item dequeue() {
		Item randItem = sample();
		Node temp = first;
		Node tempPoint;
		for (int i = 0; i <= size(); i++) {
			temp = temp.next;
			tempPoint = temp.last;

			if (randItem == temp.item) {
				temp.item = null;
			}
		}
	}

	public Item sample() {
		int r = StdRandom.uniform(0, size()+1);
		Node temp = first;

		for (int i = 0; i <= r; i++) {
			temp = temp.next;
		}
		return temp.item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterable<Item> {
		private Node current = first;

		public boolean hasNext() {
			return (current.next != null);
		}

		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}

			Item item = current.item;
			current = current.next;
			return item;
			}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		RandomizedQueue randomQ = new RandomizedQueue();
	}
}