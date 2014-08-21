package leetcode;

public class SearchInRotatedSortedArray {
	/**
	 * 1) 3 cases, 
	 *     a) The mid point is the target; 
	 *     b) pivot is on the left;
	 *     c) pivot is on the right. 
	 * 2) For case b) and c), the pivot, and the mid point divides the range 
	 *     into 3 intervals. 
	 *     (1) The second interval is on one side;
	 *     (2) the first and third intervals are on the other side. 
	 * 3) Search left half or right half based on which interval the target is in. 
	 *     This narrows down the search range by half in each
	 *     iteration, so we use binary search here. 
	 * 4) 5 cases in total: a), b)-(1), b)-(2), c)-(1), c)-(2) 
	 */
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start <= end) {
			mid = start + (end - start) / 2;

			if (A[mid] == target) {
				return mid;
			}
			// Pivot is on the right
			else if (A[start] <= A[mid]) {
				if (target < A[mid] && target >= A[start]) {
					// Search left
					end = mid - 1;
				} else {
					// Search right
					start = mid + 1;
				}
			}
			// Pivot is on the left
			else {
				if (target > A[mid] && target <= A[end]) {
					// Search right
					start = mid + 1;
				} else {
					// Search left
					end = mid - 1;
				}
			}
		}

		return -1;
	}
}