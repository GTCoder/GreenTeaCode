package leetcode;

public class SearchInRotatedSortedArrayII {
	/**
	 * The difference between I and II is that, it is possible that A[start] ==
	 * A[mid]. In this case, there is no way to determine whether the pivot is
	 * on the left or right. So we need to search the left half, AND the right
	 * half. Therefore, we have to use recursive instead of iterative to
	 * implement the search.
	 */
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		return searchRecursive(A, 0, A.length - 1, target);
	}

	private boolean searchRecursive(int[] A, int start, int end, int target) {
		if (start > end) {
			return false;
		}

		int mid = start + (end - start) / 2;
		if (A[mid] == target) {
			return true;
		}
		// Pivot is on right
		else if (A[start] < A[mid]) {
			if (target < A[mid] && target >= A[start]) {
				// Search left
				return searchRecursive(A, start, mid - 1, target);
			} 
			else {
				// Search right
				return searchRecursive(A, mid + 1, end, target);
			}
		}
		// Pivot is on left
		else if (A[start] > A[mid]) {
			if (target > A[mid] && target <= A[end]) {
				// Search right
				return searchRecursive(A, mid + 1, end, target);
			} 
			else {
				// Search left
				return searchRecursive(A, start, mid - 1, target);
			}
		} 
		else {
			boolean isOnLeft = searchRecursive(A, start, mid - 1, target);
			if (!isOnLeft) {
				return searchRecursive(A, mid + 1, end, target);
			} 
			else {
				return isOnLeft;
			}
		}
	}
}
