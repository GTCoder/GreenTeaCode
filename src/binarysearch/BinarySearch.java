package binarysearch;

public class BinarySearch {
	public int binarySearchIterative(int[] array, int start, int end, int target) {
		if (array == null || array.length == 0 || start > end || start < 0 || end >= array.length) {
			return -1;
		}

		int mid;

		while (start <= end) {
//			mid = (start + end) / 2;
			mid = start + (end - start) / 2;
			if (array[mid] < target) {
				start = mid + 1;
			} 
			else if (array[mid] == target) {
				return mid;
			} 
			else {
				end = mid - 1;
			}
		}

		return -1;
	}
	
	public int binarySearchRecursive(int[] array, int start, int end, int target) {
		if (array == null || array.length == 0 || start > end || start < 0 || end >= array.length) {
			return -1;
		}
		
//		int mid = (start + end) / 2;
		int mid = start + (end - start) / 2;
		
		if (array[mid] < target) {
			return binarySearchRecursive(array, mid + 1, end, target);
		}
		else if (array[mid] == target) {
			return mid;
		}
		else {
			return binarySearchRecursive(array, start, mid - 1, target);
		}
	}
}
