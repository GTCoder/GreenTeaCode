package graph.directed;

import java.util.LinkedList;

public class Graph {
	public void breadthFirstSearch(DirectedGraphNode node) {
		if (node == null) {
			return;
		}
		
		// For LinkedList, two operations: add() and removeFirst()
		LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		
		this.visit(node);							// First visit it
		node.state = State.Visiting;				// Then mark it as "Visiting"		
		queue.add(node);
		
		while (!queue.isEmpty()) {
			DirectedGraphNode cur = queue.removeFirst();
			for (DirectedGraphNode neighbor : cur.getAdjacent()) {
				if (neighbor.state == State.Unvisited) {
					this.visit(neighbor);			// First visit it
					neighbor.state = State.Visiting;// Then mark it as "Visiting"
					queue.add(neighbor);					
				}
			}
			// Finally, after all its neighbors have been touched, mark it as "Visited"
			cur.state = State.Visited;
		}				
	}
	
	public void depthFirstSearchIterative(DirectedGraphNode node) {
		if (node == null) {
			return;
		}
		
		LinkedList<DirectedGraphNode> stack = new LinkedList<DirectedGraphNode>();
		
		this.visit(node);							// First visit it
		node.state = State.Visiting;				// Then mark it as "Visiting"
		stack.add(node);
		
		while (!stack.isEmpty()) {
			DirectedGraphNode cur = stack.removeLast();
			for (DirectedGraphNode neighbor : cur.getAdjacent()) {
				if (neighbor.state == State.Unvisited) {
					this.visit(neighbor);			// First visit it
					neighbor.state = State.Visiting;// Then mark it as "Visiting"
					stack.add(neighbor);
				}
			}
			// Finally, after all its neighbors have been touched, mark it as "Visited"
			cur.state = State.Visited;
		}				
	}
	
	public void depthFirstSearchRecursive(DirectedGraphNode node) {
		if (node == null) {
			return;
		}
		
		this.visit(node);							// First visit it
		node.state = State.Visiting;				// Then mark it as "Visiting"
		
		for (DirectedGraphNode neighbor : node.getAdjacent()) {
			if (neighbor.state == State.Unvisited) {
				depthFirstSearchRecursive(neighbor);
			}
		}
		// Finally, after all its neighbors have been touched, mark it as "Visited"
		node.state = State.Visited;
	}
	
	public void visit(DirectedGraphNode node) {
		System.out.println(String.format("Visit node: %d", node.data));
	}
	
	public static void main(String[] args) {
		DirectedGraphNode node0 = new DirectedGraphNode(0);
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		
		node0.connectTo(node1);
		node1.connectTo(node2);
		node1.connectTo(node3);
		node2.connectTo(node3);
		node3.connectTo(node0);
		
//		0 -> 1 -> 2
//		 ^   |   /
//		  \  v  v
//		     3
		Graph solver = new Graph();
		
		node0.state = State.Unvisited;
		node1.state = State.Unvisited;
		node2.state = State.Unvisited;
		node3.state = State.Unvisited;
		solver.breadthFirstSearch(node0);
//		Output:
//		Visit node: 0
//		Visit node: 1
//		Visit node: 2
//		Visit node: 3
		
		node0.state = State.Unvisited;
		node1.state = State.Unvisited;
		node2.state = State.Unvisited;
		node3.state = State.Unvisited;
		solver.depthFirstSearchRecursive(node0);
//		Output:
//		Visit node: 0
//		Visit node: 1
//		Visit node: 2
//		Visit node: 3	
		
		node0.state = State.Unvisited;
		node1.state = State.Unvisited;
		node2.state = State.Unvisited;
		node3.state = State.Unvisited;
		solver.depthFirstSearchIterative(node0);
//		Output:
//		Visit node: 0
//		Visit node: 1
//		Visit node: 2
//		Visit node: 3
	}

}
