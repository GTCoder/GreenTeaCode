package tree.binarysearchtree;

public class BSTreeNode<K extends Comparable<K>, V> {
	public K key;
	public V value;
	public int N; // # of nodes in both subtrees;
	public BSTreeNode<K, V> left;
	public BSTreeNode<K, V> right;
	
	public BSTreeNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.N = 0;
	}
	
	public int getSizeOfSubtrees(){
		return this.N;
	}
	
	public int getSizeOfLeftSubtree() {
		if (this.left == null) {
			return 0;
		}
		else {
			return this.left.getSizeOfSubtrees() + 1;
		}
	}
	
	public int getSizeOfRightSubtree() {
		if (this.right == null) {
			return 0;
		}
		else {
			return this.right.getSizeOfSubtrees() + 1;
		}
	}
	
	public void put(K key, V value) {
		if (key == null || value == null) {
			return;
		}
		
		if (key.compareTo(this.key) < 0) {
			if (this.left == null) {
				this.left = new BSTreeNode<K, V>(key, value);				
			}
			else {
				this.left.put(key, value);
			}
			this.N++;
		}
		else if (key.compareTo(this.key) == 0) {
			this.value = value;
			return;
		}
		else {
			if (this.right == null) {
				this.right = new BSTreeNode<K, V>(key, value);
			}
			else {
				this.right.put(key, value);
			}
			this.N++;
		}
	}
	
	public V getValue(K key) {
		return this.getNode(key).value;
	}
	
	public BSTreeNode<K, V> getNode(K key) {
		if (key.compareTo(this.key) < 0) {
			if (this.left == null) {
				return null;
			}
			else {
				return this.left.getNode(key);
			}
		}
		else if (key.compareTo(this.key) == 0) {
			return this;
		}
		else {
			if (this.right == null) {
				return null;
			}
			else {
				return this.right.getNode(key);
			}
		}
	}
	
	// Do not forget the terminating condition
	public int getRank(K key) {
		// Terminating condition!
		if (key == null) {
			return -1;
		}
		
		if (key.compareTo(this.key) < 0) {
			return this.left.getRank(key);
		}
		else if (key.compareTo(this.key) == 0) {
			return this.getSizeOfLeftSubtree();
		}
		else {
			int rightRank = this.right.getRank(key);
			// Terminating condition!
			if (rightRank == -1) {
				return rightRank;
			}
			else {
				return this.getSizeOfLeftSubtree() + 1 + rightRank;
			}
		}
	}
}
