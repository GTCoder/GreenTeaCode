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
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
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
				stack.push(node);
				node = node.left;
			}
			// Go back one step, and then go to the right branch
			else {
				node = stack.pop();
				// Visit current node (in-order)
				res.add(node.val);
				node = node.right;
			}
		}

		return res;
	}
}
