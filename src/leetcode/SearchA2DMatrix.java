package leetcode;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int r = matrix.length;
		int c = matrix[0].length;

		int start = 0;
		int end = r * c - 1;
		int mid;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (matrix[mid / c][mid % c] > target) {
				end = mid - 1;
			}
			else if (matrix[mid / c][mid % c] == target) {
				return true;
			}
			else {
				start = mid + 1;
			}
		}

		return false;
	}
}
