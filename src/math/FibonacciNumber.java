package math;

/**
 * 1. In the for loop, i starts at 2!!!
 * 2. Fib(0) = 0, Fib(1) = 1
 */
public class FibonacciNumber {
	public int fib(int n) {
		int f0 = 0;
		int f1 = 1;
		int fn = f1;
		if (n == 0) {
			return f0;
		}
		
		for (int i = 2; i <= n; i++) {
			fn = f0 + f1;
			f0 = f1;
			f1 = fn;
		}
		
		return f1;
	}
	
	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
	public static void main(String[] args) {
		int n = 10;
		FibonacciNumber myFib = new FibonacciNumber();
		System.out.println(myFib.fib(n));		
	}
}
