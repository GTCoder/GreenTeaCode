package leetcode;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		
		if (A == null || A.length == 0) {
			return res;
		}
		
		res[0] = searchRangeStart(A, 0, A.length, target);
		res[1] = searchRangeEnd(A, 0, A.length, target);
		
		return res;
	}
	
	private int searchRangeStart(int[] A, int start, int end, int target) {
		int mid;
		
		// "<=", not "<", DO NOT forget "="
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (A[mid] < target) {
				start = mid + 1;
			}
			else if (A[mid] == target) {
				// Note that there are two cases!				
				if (mid == start || A[mid-1] < target) {
					return mid;
				}
				else {
					end = mid - 1;
				}
			}
			else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	private int searchRangeEnd(int[] A, int start, int end, int target) {
		int mid;
		
		// "<=", not "<", DO NOT forget "="
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (A[mid] < target) {
				start = mid + 1;
			}
			else if (A[mid] == target) {
				// Note that there are two cases!
				if (mid == end || A[mid + 1] > target) {
					return mid;
				}
				else {
					start = mid + 1;
				}
			}
			else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,1,2,2,2,2,2,2,2,3};
		
		SearchForARange solver = new SearchForARange();
		int[] res = solver.searchRange(A, 2);
		
		System.out.println(String.format("[%d, %d]", res[0], res[1]));
	}
}
