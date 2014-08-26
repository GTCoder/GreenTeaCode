package leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (A[mid] > target) {
				end = mid - 1;
			}
			else if (A[mid] == target) {
				return mid;
			}
			else {
				start = mid + 1;
			}
		}

		// Or return end + 1
		return start;
	}
}
