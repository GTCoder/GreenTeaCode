package leetcode;

public class MaximumSubarray {
	/**
	 * Tags: Array
	 */
    public int maxSubArray(int[] A) {
    	if (A == null || A.length == 0) {
    		return 0;
    	}
    	
    	int sum = 0;
    	int max = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < A.length; i++) {
    		sum += A[i];
    		max = Math.max(max, sum);
    		sum = Math.max(0, sum);    		
    	}
    	
    	return max;
    }
}
