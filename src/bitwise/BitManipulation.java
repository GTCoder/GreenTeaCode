package bitwise;

public class BitManipulation {
	public boolean getBit(int num, int index) {
		return (num & (1 << index)) != 0;
	}

	public int setBit(int num, int index) {
		return num | (1 << index);
	}

	public int clearBit(int num, int index) {
		return num & (~(1 << index));
	}

	/**
	 * Clear all bits lower than the index (inclusive)
	 * 
	 * @param num
	 *            the number
	 * @param index
	 *            the index
	 * @return result
	 */
	public int clearLowBits(int num, int index) {
		int mask = ~((1 << (index + 1)) - 1);
		return num & mask;
	}

	/**
	 * Clear all bits higher than the index (inclusive)
	 * 
	 * @param num
	 *            the number
	 * @param index
	 *            the index
	 * @return result
	 */
	public int clearHighBits(int num, int index) {
		int mask = (1 << index) - 1;
		return num & mask;
	}

	/**
	 * Clear all bits in a range
	 * 
	 * @param num
	 *            the number
	 * @param high
	 *            the high bound of the range (inclusive)
	 * @param low
	 *            the low bound of the range (inclusive)
	 * @return result
	 */
	public int clearBits(int num, int high, int low) {
		return clearHighBits(num, low) | clearLowBits(num, high);
	}

	/**
	 * Flip the least Significant digit
	 * 
	 * @param bit
	 *            input
	 * @return int after flip
	 */
	public int flip(int bit) {
		return 1 ^ bit;
	}

	/**
	 * Check if an integer is positive or negative
	 * 
	 * @param n
	 *            the integer
	 * @return 1 if positive, 0 if negative
	 */
	public int getSign(int n) {
		return flip((n >> 31) & 0x1);
	}
}
