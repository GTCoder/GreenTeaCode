package ctci.chapter8;

import java.util.LinkedList;

public class Hash<K, V> {
	private int maxSize;
	LinkedList<KeyValuePair<K, V>>[] array;

	@SuppressWarnings("unchecked")
	public Hash(int size) {
		this.maxSize = size;
		// this.array = new LinkedList<KeyValuePair<K, V>>[maxSize] would not
		// work - error: cannot create a generic array of
		// LinkedList<KeyValuePair<K, V>>
		this.array = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[maxSize];
	}

	public void put(K key, V value) {
		int hashCode = getHashCode(key) % this.maxSize;
		// Note: the entry could be null at first time use!
		if (this.array[hashCode] == null) {
			this.array[hashCode] = new LinkedList<KeyValuePair<K, V>>();
		}

		LinkedList<KeyValuePair<K, V>> list = this.array[hashCode];

		for (KeyValuePair<K, V> pair : list) {
			if (pair.key.equals(key)) {
				list.remove(pair);
				break;
			}
		}

		KeyValuePair<K, V> pair = new KeyValuePair<K, V>(key, value);
		list.add(pair);
	}

	public V get(K key) {
		int hashCode = getHashCode(key) % this.maxSize;
		if (this.array[hashCode] == null) {
			return null;
		}

		LinkedList<KeyValuePair<K, V>> list = this.array[hashCode];
		for (KeyValuePair<K, V> pair : list) {
			if (pair.key.equals(key)) {
				return pair.value;
			}
		}

		return null;
	}

	private int getHashCode(K key) {

		return key.hashCode();
	}

}
