package sort;

/**
 * 3-way partition variation of quick sort has better performance when there are
 * only few unique keys to sort, so use always use the 3-way partition instead
 * of the standard 2-way partition.
 * 
 * Both 2-way partition and 3-way partition are very tricky!!!
 * 
 * Reference URL: http://www.sorting-algorithms.com/
 */

public class QuickSort {
	public void quicksort1(int[] A, int start, int end) {
		if (A == null || A.length == 0 || start < 0 || end >= A.length) {
			return;
		}

		if (start >= end) {
			return;
		}

		int p = this.makeTwoWayPartition(A, start, end);
		quicksort1(A, start, p - 1);
		quicksort1(A, p + 1, end);
	}

	public int makeTwoWayPartition(int[] A, int start, int end) {
		int pivotIndex = getPivotIndex(A, start, end);
		int pivot = A[pivotIndex];
		swap(A, pivotIndex, end);

		int i = start;
		int p = start;
		while (i <= end - 1) {
			// Just move any small integer encountered by i to the first half
			if (A[i] <= pivot) {
				swap(A, i, p);
				p++;
			}
			i++;
		}
		swap(A, p, end);

		return p;
	}

	public void quicksort2(int[] A, int start, int end) {
		if (A == null || A.length == 0 || start < 0 || end >= A.length) {
			return;
		}

		if (start >= end) {
			return;
		}

		int[] partitions = this.makeThreeWayPartition(A, start, end);
		int p1 = partitions[0];
		int p2 = partitions[1];
		quicksort2(A, start, p1 - 1);
		quicksort2(A, p2 + 1, end);
	}

	public int[] makeThreeWayPartition(int[] A, int start, int end) {
		int pivotIndex = getPivotIndex(A, start, end);
		int pivot = A[pivotIndex];

		int p = start;
		while (p <= end) {
			if (A[p] > pivot) {
				swap(A, p, end);
				end--;
			}
			else if (A[p] < pivot) {
				swap(A, p, start);
				start++;
				p++;
			}
			else {
				p++;
			}
		}

		int[] res = new int[2];
		res[0] = start;
		res[1] = end;

		return res;
	}

	private int getPivotIndex(int[] A, int start, int end) {
		int mid = start + (end - start);
		return getMedianOfThree(A, start, mid, end);
	}

	private int getMedianOfThree(int[] A, int first, int second, int third) {
		int[] indices = new int[] { first, second, third };
		for (int i = 0; i < indices.length; i++) {
			if (isMedianOfThree(A, indices[i],
					indices[(i + 1) % indices.length], indices[(i + 2)
							% indices.length])) {
				return indices[i];
			}
		}

		return indices[0];
	}

	private boolean isMedianOfThree(int[] A, int medianIndex, int a, int b) {
		return ((A[medianIndex] <= Math.max(A[a], A[b])) && (A[medianIndex] >= Math
				.min(A[a], A[b])));
	}

	private void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
