package graph.directed;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
	public State state;
	public int data;
	private List<DirectedGraphNode> adjacentNodes;
	
	public DirectedGraphNode(int data) {
		this.state = State.Unvisited;
		this.data = data;
		this.adjacentNodes = new ArrayList<DirectedGraphNode>();
	}
	
	public void connectTo(DirectedGraphNode node) {
		this.adjacentNodes.add(node);
	}
	
	public List<DirectedGraphNode> getAdjacent() {
		return this.adjacentNodes;
	}
}
