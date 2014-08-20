package leetcode;

import linkedlist.ListNode;

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
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Validate input
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = getNextDifferent(cur);
            if (next == cur.next) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
            else {
                pre.next = next;
                cur = next;
            
            }
        }
        
        return dummy.next;
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