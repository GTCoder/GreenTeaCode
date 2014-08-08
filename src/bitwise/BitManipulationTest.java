package bitwise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitManipulationTest {
	private BitManipulation myBitManipulation;

	@Before
	public void initialize() {
		this.myBitManipulation = new BitManipulation();
	}

	@Test
	public void testGetBit() {
		int num = 0;

		num = 0;
		assertEquals(false, this.myBitManipulation.getBit(num, 0));

		num = 1;
		assertEquals(true, this.myBitManipulation.getBit(num, 0));

		num = 5;
		assertEquals(true, this.myBitManipulation.getBit(num, 0));
		assertEquals(false, this.myBitManipulation.getBit(num, 1));
		assertEquals(true, this.myBitManipulation.getBit(num, 2));
	}

	@Test
	public void testSetBit() {
		int num = 0;

		num = 0;
		assertEquals(1, this.myBitManipulation.setBit(num, 0));
		assertEquals(2, this.myBitManipulation.setBit(num, 1));
		assertEquals(4, this.myBitManipulation.setBit(num, 2));
		assertEquals(
				5,
				this.myBitManipulation.setBit(
						this.myBitManipulation.setBit(num, 0), 2));

		num = 7;
		assertEquals(7, this.myBitManipulation.setBit(num, 1));
	}

	@Test
	public void testClearBits() {
		int num = 0;

		// Test clearLowBits()
		num = 15; // 1111
		assertEquals(14, this.myBitManipulation.clearLowBits(num, 0)); // 1110
		assertEquals(12, this.myBitManipulation.clearLowBits(num, 1)); // 1100

		// Test clearHighBits()
		num = 15; // 1111
		assertEquals(0, this.myBitManipulation.clearHighBits(num, 0)); // 0000
		assertEquals(1, this.myBitManipulation.clearHighBits(num, 1)); // 0001
		assertEquals(3, this.myBitManipulation.clearHighBits(num, 2)); // 0011

		// Test clearBits()
		num = 15; // 1111
		assertEquals(8, this.myBitManipulation.clearBits(num, 2, 0)); // 1000
	}
}
