package leetcode;

/**
 * We move s forward, at each position, we compare the element with the next one:
 *     1) if they are same, then continue move s;
 *     2) otherwise copy s to d, and move both s and d by 1. 
 * Finaly when s hits the last, return d.
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		// Validate input
		if (A == null || A.length == 0) {
			return 0;
		}

		int s = 0;
		int d = 0;
		int k = 1;
		while (s < A.length) {
			// Here it is needed to make sure s+k is not out-of-index!
			while (s + k < A.length && A[s] == A[s + k]) {
				s++;
			}
			A[d] = A[s];
			s++;
			d++;
		}

		return d;
	}
}
