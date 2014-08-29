package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
	/**
	 * Note that here in the stack are indices, not the values!!!
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> lStack = new Stack<Integer>();
		int[] leftIndices = new int[height.length];

		for (int i = 0; i < height.length; i++) {
			// Note that here in the stack are indices, not values, so use
			// height[rStack.peek()] instead of lStack.peek().
			while (!lStack.isEmpty() && height[lStack.peek()] >= height[i]) {
				lStack.pop();
			}
			if (lStack.isEmpty()) {
				leftIndices[i] = -1;
			}
			else {
				leftIndices[i] = lStack.peek();
			}
			lStack.push(i);
		}

		Stack<Integer> rStack = new Stack<Integer>();
		int[] rightIndices = new int[height.length];

		for (int i = height.length - 1; i >= 0; i--) {
			// Note that here in the stack are indices, not values, so use
			// height[rStack.peek()] instead of rStack.peek().
			while (!rStack.isEmpty() && height[rStack.peek()] >= height[i]) {
				rStack.pop();
			}
			if (rStack.isEmpty()) {
				rightIndices[i] = height.length;
			}
			else {
				rightIndices[i] = rStack.peek();
			}
			rStack.push(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			int newRect = height[i] * (rightIndices[i] - leftIndices[i] - 1);
			max = Math.max(max, newRect);
		}

		return max;
	}
}
