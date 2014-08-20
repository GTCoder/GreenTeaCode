package leetcode;

import linkedlist.ListNode;

/**
 * 1. No need to add a dummy head, because the first node will be always kept!!!
 * 2. Use the getNextDifferent() method to get the next different node
 * 3. After get the next different node, there is only one way to handle, no need to handle two cases.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		// Validate input
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		while (cur != null) {
			ListNode next = getNextDifferent(cur);
			cur.next = next;
			cur = cur.next;
		}

		return head;
	}

	private ListNode getNextDifferent(ListNode p) {
		if (p == null) {
			return p;
		}

		if (p.next == null) {
			return null;
		}

		ListNode next = p.next;
		while (next != null && next.val == p.val) {
			next = next.next;
		}

		return next;
	}
}
