package sort;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class MergeSortTest {
	private MergeSort sorter = new MergeSort(); 
	
	@Test
	public void testMergeSort() {
		int length = 10;
		int max = 10;
		int[] array = new int[length];
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			array[i] = rand.nextInt(max);
		}
		
		sorter.sort(array);
		
		for (int i = 0; i < length - 1; i++) {
			assertTrue(array[i] <= array[i+1]);
		}
	}
}
