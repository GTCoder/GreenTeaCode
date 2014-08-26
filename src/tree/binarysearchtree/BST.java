package tree.binarysearchtree;

/**
 * Reference to URL: algs4.cs.princeton.edu/32bst/BST.java.html
 * 
 * The tricky parts come from the recursively insert (put), and search (get).
 * 
 * Remember to distinguish the two cases when go to the left/right branch:
 *     1) if the left/right child is null
 *     2) if the left/right child is NOT null
 *     
 * For CTCT P118: Get rank of an integer in a stream of integers:
 *     Remember the terminating condition in the recursion of getRank() method. 
 * @author Dongye
 * 
 */
public class BST<K extends Comparable<K>, V> {
	public BSTreeNode<K, V> root;

	public BST() {
		this.root = null;
	}

	public void put(K key, V value) {
		if (root == null) {
			this.root = new BSTreeNode<K, V>(key, value);
		}
		else {
			this.root.put(key, value);
		}
	}

	public V getValue(K key) {
		if (root == null) {
			return null;
		}
		else {
			return this.root.getNode(key).value;
		}
	}

	public BSTreeNode<K, V> getNode(K key) {
		if (root == null) {
			return null;
		}
		else {
			return this.root.getNode(key);
		}
	}
	
	public int getRank(K key) {
		if (this.root == null) {
			return -1;
		}
		else {
			return this.root.getRank(key);
		}
	}

	public static void main(String[] args) {		
//		                        <20, 4>
//		                     /           \
//		                <15, 3>         <25, 3>
//		               /                /
//		           <10, 1>           <23, 1>
//		           /     \           /     \
//		       <5, 0>   <13, 0>   <22, 0>  <24, 0>
		BST<Integer, Integer> myBST = new BST<Integer, Integer>();

		int[] inputKey = new int[] { 20, 15, 10, 5, 13, 25, 23, 22, 24 };
		int[] inputValue = new int[] { 4, 3, 1, 0, 0, 3, 1, 0, 0 };

		for (int i = 0; i < inputKey.length; i++) {
			myBST.put(inputKey[i], inputValue[i]);
		}

		for (int i = 0; i < inputKey.length; i++) {
			System.out.println(inputKey[i]);
			BSTreeNode<Integer, Integer> node = myBST.getNode(inputKey[i]);
			System.out.println(node);
			System.out.println(String.format(
					"Get Key %d\n\tValue: %d\n\tSize of left: %d\n",
					inputKey[i], node.value, node.getSizeOfLeftSubtree()));
		}

	}

}
