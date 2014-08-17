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
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		TreeNode lastVisited = null;

		// Note that there are two conditions in the while loop		
		while (!stack.isEmpty() || node != null) {
			// Go to left as far as possible
			if (node != null) {
				stack.push(node);
				node = node.left;
			} 
			// Go back one step
			else {
				TreeNode top = stack.peek();
				// If the right sub-tree has already been visited, then visit the current node
				if (lastVisited == top.right || top.right == null) {
					node = stack.pop();
					res.add(node.val);
					lastVisited = node;
					node = null; // Remember to set node be null!!!
				} 
				// If the right sub-tree has not been visited, then go to the right sub-tree
				else {
					node = top.right;
				}
			}
		}

		return res;
	}
}
