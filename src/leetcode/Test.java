package leetcode;

public class Test {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] >= n && (mid == start || A[mid-1]<n)) {
                return mid;
            }
            else if (A[mid] >= n) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
            
        }
        
        return start;
    }
    
	public static void main(String[] args) {
		Test myTest = new Test();
		int[] A = new int[1];
		A[0] = 1;
		int res = myTest.searchInsert(A, 2);
		System.out.println(res);
		
		

	}

}
