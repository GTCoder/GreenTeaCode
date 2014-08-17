package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Note: Stack - push(), pop(), peek()
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		// Note that there are two conditions in the while loop
		while (!stack.isEmpty() || node != null) {
			// Go to left as far as possible
			if (node != null) {
				res.add(node.val);
				// Visit current node (pre-order)
				stack.push(node);
				node = node.left;
			}
			// Go back one step, and then go to the right branch
			else {
				node = stack.pop();
				node = node.right;
			}
		}

		return res;
	}
}