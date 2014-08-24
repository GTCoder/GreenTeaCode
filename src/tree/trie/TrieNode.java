package tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode<V> {
	public Map<Character, TrieNode<V>> children;
	public Character key;
	public V value;
	
	public TrieNode(Character key, V value) {
		this.children = new HashMap<Character, TrieNode<V>>();
		this.key = key;
		this.value = value;
	}
}
