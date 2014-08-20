package leetcode;

/**
 * Generally speaking, if duplicates are allowed at most n times, then just set
 * k be n
 */
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null) {
			return -1;
		}

		if (A.length == 0) {
			return 0;
		}

		int s = 0;
		int d = 0;
		int k = 2;
		while (s < A.length) {
			// Here it is needed to make sure s+k is not out-of-index!
			while (s + k < A.length && A[s + k] == A[s]) {
				s++;
			}
			A[d] = A[s];
			s++;
			d++;
		}

		return d;
	}
}
