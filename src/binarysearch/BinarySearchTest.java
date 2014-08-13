package binarysearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
	private int[] array;
	private int[] array0;
	private int[] array1;
	private int[] array2;
	private int[] array7;
	
	BinarySearch bs = new BinarySearch();

	@Before
	public void initialize() {
		this.array = null;
		this.array0 = new int[0];
		this.array1 = new int[] { 1 };
		this.array2 = new int[] { 1, 2 };
		this.array7 = new int[] { 1, 2, 2, 2, 3, 4, 5 };
	}

	@Test
	public void testBinarySearch() {
		// Test iterative
		assertEquals(-1, bs.binarySearchIterative(this.array, 0, 1, 1));		
		assertEquals(-1, bs.binarySearchIterative(this.array0, 0, 0, 1));
		assertEquals(-1, bs.binarySearchIterative(this.array1, 0, 1, 1));
		assertEquals(0, bs.binarySearchIterative(this.array2, 0, 1, 1));
		assertEquals(1, bs.binarySearchIterative(this.array2, 0, 1, 2));
		assertEquals(-1, bs.binarySearchIterative(this.array7, 0, 6, 0));
		assertEquals(3, bs.binarySearchIterative(this.array7, 1, 5, 2));	
		assertEquals(-1, bs.binarySearchIterative(this.array7, 1, 7, 2));
		assertEquals(-1, bs.binarySearchIterative(this.array7, 0, 6, 0));
		assertEquals(0, bs.binarySearchIterative(this.array7, 0, 6, 1));
		assertEquals(4, bs.binarySearchIterative(this.array7, 0, 6, 3));
		assertEquals(6, bs.binarySearchIterative(this.array7, 0, 6, 5));
		
		// Test recursive
		assertEquals(-1, bs.binarySearchRecursive(this.array, 0, 1, 1));		
		assertEquals(-1, bs.binarySearchRecursive(this.array0, 0, 0, 1));
		assertEquals(-1, bs.binarySearchRecursive(this.array1, 0, 1, 1));
		assertEquals(0, bs.binarySearchRecursive(this.array2, 0, 1, 1));
		assertEquals(1, bs.binarySearchRecursive(this.array2, 0, 1, 2));
		assertEquals(-1, bs.binarySearchRecursive(this.array7, 0, 6, 0));
		assertEquals(3, bs.binarySearchRecursive(this.array7, 1, 5, 2));	
		assertEquals(-1, bs.binarySearchRecursive(this.array7, 1, 7, 2));
		assertEquals(-1, bs.binarySearchRecursive(this.array7, 0, 6, 0));
		assertEquals(0, bs.binarySearchRecursive(this.array7, 0, 6, 1));
		assertEquals(4, bs.binarySearchRecursive(this.array7, 0, 6, 3));
		assertEquals(6, bs.binarySearchRecursive(this.array7, 0, 6, 5));
	}
}
