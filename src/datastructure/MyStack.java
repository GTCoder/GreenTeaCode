package datastructure;

import linkedlist.ListNode;

public class MyStack {
	private ListNode top;

	public MyStack() {
		this.top = null;
	}

	public void push(int d) {
		ListNode node = new ListNode(d);
		node.next = top;
		this.top = node;
	}

	public Integer pop() {
		if (this.top == null) {
			return null;
		}

		ListNode node = top;
		top = top.next;

		return node.val;
	}

	public Integer peek() {
		return this.top.val;
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
//		Output:
//		Peek: 3
//		Pop: 3
//		Pop: 2
//		Pop: 1
//		Pop: null
	}
}
