package tree.trie;

/**
 * Reference
 * Insert and search: http://www.geeksforgeeks.org/trie-insert-and-search/
 * Delete: http://www.geeksforgeeks.org/trie-delete/
 * The tricky part is delete. Use recursive. Delete in reverse order - delete the last char first.
 */
public class Trie<V> {
	public TrieNode<V> root;

	public Trie() {
		this.root = new TrieNode<V>(null, null);
	}

	public void put(String key, V value) {
		TrieNode<V> cur = this.root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			if (cur.children.containsKey(c)) {
				cur = cur.children.get(c);
				if (key.length() == 1) {
					cur.value = value;
				}
			}
			else {
				TrieNode<V> child;
				if (i == key.length() - 1) {
					child = new TrieNode<V>(c, value);
					cur.children.put(c, child);
					cur = child;
				}
				else {
					child = new TrieNode<V>(c, null);
					cur.children.put(c, child);
					cur = child;
				}
			}
		}
	}

	public V get(String key) {
		TrieNode<V> cur = this.root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			if (cur.children.containsKey(c)) {
				cur = cur.children.get(c);
				if (i == key.length() - 1) {
					return cur.value;
				}
			}
			else {
				return null;
			}
		}

		return null;
	}

	public void deleteKey(String key) {
		deleteKeyHelper(this.root, key, 0);
	}

	private boolean deleteKeyHelper(TrieNode<V> node, String key, int index) {
		if (index == key.length()) {
			return true;
		}

		if (node.children.containsKey(key.charAt(index))) {
			if (deleteKeyHelper(node.children.get(key.charAt(index)), key,
					index + 1)) {
				if (node.children.size() == 1) {
					node.children.remove(key.charAt(index));
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Trie<Boolean> trie = new Trie<Boolean>();
		trie.put("x", true);
		trie.put("az", false);
		trie.put("abc", true);

		String key;
		key = "x";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));
		key = "az";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));
		key = "abc";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));

		key = "abc";
		trie.deleteKey("abc");

		key = "x";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));
		key = "az";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));
		key = "abc";
		System.out.println(trie.get(key) == null ? String.format(
				"Get %s: null", key) : String.format("Get %s: %b", key,
				trie.get(key)));
	}
}
