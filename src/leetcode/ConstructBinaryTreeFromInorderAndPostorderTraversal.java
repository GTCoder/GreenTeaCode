package leetcode;

import tree.binarytree.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null
				|| postorder.length == 0 || inorder.length != postorder.length) {
			return null;
		}

		return buildSubTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode buildSubTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = findElement(inorder, inStart, inEnd, rootVal);

		int leftLength = rootIndex - 1 - inStart + 1;
		int rightLength = inEnd - (rootIndex + 1) + 1;
		
		// Do not forget to connect left sub-tree and right sub-tree to the root node!!!
		root.left = buildSubTree(inorder, inStart, rootIndex - 1, postorder,
				postStart, postStart + leftLength - 1);
		root.right = buildSubTree(inorder, rootIndex + 1, inEnd, postorder,
				postEnd - 1 - rightLength + 1, postEnd - 1);

		return root;
	}

	private int findElement(int[] inorder, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == target) {
				return i;
			}
		}

		return -1;
	}
}