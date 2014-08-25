package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testQuicksort1() {
		QuickSort tester = new QuickSort();

		int[] input1 = null;
		int[] expected1 = null;
		tester.quicksort1(input1, -1, -1);
		assertEquals("", expected1, input1);

		int[] input2 = new int[] { 1 };
		int[] expected2 = new int[] { 1 };
		tester.quicksort1(input2, 0, 0);
		assertArrayEquals("", expected2, input2);

		int[] input3 = new int[] { 1, 3, 2 };
		int[] expected3 = new int[] { 1, 2, 3 };
		tester.quicksort1(input3, 0, 2);
		assertArrayEquals("", expected3, input3);

		int[] input4 = new int[] { 1, 3, 2, -1 };
		int[] expected4 = new int[] { -1, 1, 2, 3 };
		tester.quicksort1(input4, 0, 3);
		assertArrayEquals("", expected4, input4);

		int[] input5 = new int[] { 5, 9, 5, 5, 1, 2, 1, 2, 9, 5, 3, 1, 5, 1, 3,
				3, 9 };
		int[] expected5 = new int[] { 1, 1, 1, 1, 2, 2, 3, 3, 3, 5, 5, 5, 5, 5,
				9, 9, 9 };
		tester.quicksort1(input5, 0, 16);
		assertArrayEquals("", expected5, input5);
	}
	
	public void testQuicksort2() {
		QuickSort tester = new QuickSort();

		int[] input1 = null;
		int[] expected1 = null;
		tester.quicksort2(input1, -1, -1);
		assertEquals("", expected1, input1);

		int[] input2 = new int[] { 1 };
		int[] expected2 = new int[] { 1 };
		tester.quicksort2(input2, 0, 0);
		assertArrayEquals("", expected2, input2);

		int[] input3 = new int[] { 1, 3, 2 };
		int[] expected3 = new int[] { 1, 2, 3 };
		tester.quicksort2(input3, 0, 2);
		assertArrayEquals("", expected3, input3);

		int[] input4 = new int[] { 1, 3, 2, -1 };
		int[] expected4 = new int[] { -1, 1, 2, 3 };
		tester.quicksort2(input4, 0, 3);
		assertArrayEquals("", expected4, input4);

		int[] input5 = new int[] { 5, 9, 5, 5, 1, 2, 1, 2, 9, 5, 3, 1, 5, 1, 3,
				3, 9 };
		int[] expected5 = new int[] { 1, 1, 1, 1, 2, 2, 3, 3, 3, 5, 5, 5, 5, 5,
				9, 9, 9 };
		tester.quicksort2(input5, 0, 16);
		assertArrayEquals("", expected5, input5);
	}

}
