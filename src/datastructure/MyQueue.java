package datastructure;

import linkedlist.ListNode;

public class MyQueue {
	private ListNode head, tail;
	
	public MyQueue() {
		this.head = null;
		this.tail = null;
	}
	
	public void enqueue(int data) {
		if (head == null) {
			ListNode node = new ListNode(data);
			head = node;
			tail = node;
		}
		// Add the new node to the tail of the list
		else {
			ListNode node = new ListNode(data);
			tail.next = node;
			tail = node;
		}
	}
	
	public Integer dequeue() {
		if (head == null) {
			return null;
		}
		
		ListNode node = head;
		head = head.next;
		
		return node.val;
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
//		Output:
//		1
//		2
//		3
//		null
	}

}
