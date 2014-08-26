package ctci.chapter11;

import tree.binarysearchtree.BST;

/**
 * Remember the terminating condition in the recursion of getRank() method!!!
 * 
 * @author Dongye
 * 
 */
public class P118 {
	BST<Integer, Integer> bst;
	
	public P118() {
		this.bst= new BST<Integer, Integer>();
	}
	
	public void track(int n) {
		this.bst.put(n, -1);
	};
	
	public int getRank(int d) {
		return bst.root.getRank(d);
	}

	public static void main(String[] args) {
//        <20, 4>
//     /           \
//<15, 3>         <25, 3>
///                /
//<10, 1>           <23, 1>
///     \           /     \
//<5, 0>   <13, 0>   <22, 0>  <24, 0>
		BST<Integer, Integer> myBST = new BST<Integer, Integer>();

		int[] inputKey = new int[] { 20, 15, 10, 5, 13, 25, 23, 22, 24 };

		for (int i = 0; i < inputKey.length; i++) {
			myBST.put(inputKey[i], -1);
		}

		for (int i = 0; i < inputKey.length; i++) {
			int key = inputKey[i];
			System.out.println(inputKey[i]);
			System.out.println(String.format(
					"Get Key %d:\n\trank is %d\n",
					inputKey[i], myBST.getRank(key)));
		}
	}
}


