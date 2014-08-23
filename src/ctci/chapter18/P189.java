package ctci.chapter18;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. If the number of integers is odd, then the median is the average of the
 * middle two integers 
 * 
 * 2. The mini heap is on bottom (larger), and the max heap is on top (smaller).
 * See below:
 * 
 *   Max Heap
 * 
 *    Median
 * 
 *   Mini Heap 
 * 
 * 3. The mini heap either 1) has same size as that of the max
 * heap; or 2) have one more integer than that of the max heap
 */
/**
 * For PriorityQueue: 
 * 1. The constructor that pass a comparator in is:
 * PriorityQueue(initialCapacity, comparator). 
 *     1.1 Note that, the initialCapacity cannot be 0!!! 
 * 2. Methods of PriorityQueue: 
 *     2.1 peek(): get top 
 *     2.2 poll(): get and remove top 
 */
public class P189 {
	PriorityQueue<Integer> miniHeap;
	PriorityQueue<Integer> maxHeap;

	public P189() {
		Comparator<Integer> comp = new Comparator<Integer>() {
			// The name of the override method is compare(), NOT compareTo()!!!
			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 > i2) {
					return -1;
				} 
				else if (i1 == i2) {
					return 0;
				} 
				else {
					return -1;
				}
			}
		}; // Don't forget this semicolon!

		this.miniHeap = new PriorityQueue<Integer>();

		// 1 is the initialCapacity of the priority queue.
		// Note: The initialCapacity can NOT be 0!!!
		this.maxHeap = new PriorityQueue<Integer>(1, comp);
	}

	public void add(int n) {
		if (this.miniHeap.size() == this.maxHeap.size()) {
			if ((this.maxHeap.size() > 0) && (n < this.maxHeap.peek())) {
				this.miniHeap.add(this.maxHeap.poll());
				this.maxHeap.add(n);
			} 
			else {
				this.miniHeap.add(n);
			}
		} 
		else {
			if (n > this.miniHeap.peek()) {
				this.maxHeap.add(this.miniHeap.poll());
				this.miniHeap.add(n);
			} 
			else {
				this.maxHeap.add(n);
			}
		}
	}

	public double getMedian() {
		if (this.miniHeap.size() == 0) {
			return 0;
		}

		if (this.miniHeap.size() == this.maxHeap.size()) {
			return (((double) this.miniHeap.peek()) + ((double) this.maxHeap
					.peek())) / 2;
		} 
		else {
			return this.miniHeap.peek();
		}
	}

	public static void main(String[] args) {
		P189 tester = new P189();
		int[] input = new int[] { 1, 5, 7, 6, 8, -3, 3, -1, 0, 49, 2 };

		for (int i = 0; i < input.length; i++) {
			tester.add(input[i]);
			double median = tester.getMedian();
			String msg1 = "The median of ";
			String msg2 = "";
			for (int j = 0; j <= i; j++) {
				msg2 = msg2 + input[j] + ", ";
			}
			msg2 = msg2.substring(0, msg2.length() - 1);
			msg2 = "[" + msg2 + "]";
			String msg3 = " is " + median;
			System.out.println(msg1 + msg2 + msg3);
		}
	}
}