package math;

import java.util.Arrays;

/**
 * What is prime number?
 * "A prime number is a natural number GREAT THAN 1 that has no positive divisors other than 1 and itself."
 * - Wikipedia 
 * 
 * Note:  1) 2 is a prime number!
 *        2) The cross off should start at prime * prime, because any k * prime where k < prime should 
 *           already been crossed off in a prior iteration     
 *  
 */
public class PrimeNumber {

	public boolean isPrime(int n) {
		if (!(n > 1)) {
			return false;
		}

		int upperBound = (int) Math.sqrt(n);
		for (int i = 2; i <= upperBound; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	boolean[] getListOfPrimeNumbers(int max) {
		boolean[] flags = new boolean[max + 1];
		Arrays.fill(flags, true);

		flags[0] = false;
		flags[1] = false;

		int prime = 2; // 2 is a prime number
		while (prime <= max) {
			crossOff(flags, prime);

			prime = getNextPrime(flags, prime);
		}

		return flags;
	}

	private void crossOff(boolean[] flags, int prime) {
		// The cross off should start at prime * prime, because any k * prime
		// where k < prime should already been crossed off in a prior iteration
		for (int i = prime * prime; i < flags.length; i = i + prime) {
			flags[i] = false;
		}
	}

	// When it reach to the end of the search range, it would eventually return
	// flags.length, which is out-of-index
	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;

		while (next < flags.length) {
			if (flags[next]) {
				return next;
			}
			next++;
		}

		return next;
	}

	public static void main(String[] args) {
		PrimeNumber solver = new PrimeNumber();

		// Find all prime numbers in [0, 100]

		String res;
		res = "[Method 1]\nPrime numbers: ";
		for (int i = 0; i <= 100; i++) {
			if (solver.isPrime(i)) {
				res = res + i + ", ";
			}
		}
		System.out.println(res);

		boolean[] flags = solver.getListOfPrimeNumbers(100);
		res = "\n[Method 2]:\nPrime numbers: ";
		for (int i = 0; i <= 100; i++) {
			if (flags[i]) {
				res = res + i + ", ";
			}
		}
		System.out.println(res);

		// Output:
		// [Method 1]
		// Prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
		// 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
		//
		// [Method 2]:
		// Prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
		// 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
	}

}
