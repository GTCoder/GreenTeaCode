package sort;

/**
 * 1. In mergeSort(), do not forget to add the terminating case (check if start < end)!!!
 * 2. In merge(), initialize another temporary array temp to hold the sorted integers temporarily
 */
public class MergeSort {
	public void sort(int[] array) {
		mergesort(array, 0, array.length - 1);
	}
	
	private void mergesort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergesort(array, start, mid);
		mergesort(array, mid+1, end);
		merge(array, start, mid, end);
	}
	
	private void merge(int[] array, int start, int mid, int end) {
		int [] temp = new int[array.length];
		int p = 0;
		int p1 = start;
		int p2 = mid + 1;
		
		while (p1 <= mid && p2 <= end) {
			if (array[p1] <= array[p2]) {
				temp[p] = array[p1];
				p++;
				p1++;
			}
			else {
				temp[p] = array[p2];
				p++;
				p2++;
			}
		}
		
		while (p1 <= mid) {
			temp[p] = array[p1];
			p++;
			p1++;
		}
		
		while (p2 <= end) {
			temp[p] = array[p2];
			p++;
			p2++;
		}
		
		p = 0;
		for (int i = start; i <= end; i++) {
			array[i] = temp[p];
			p++;
		}
	}
}
