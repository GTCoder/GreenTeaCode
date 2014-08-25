package ctci.chapter8;

public class KeyValuePair<K, V> {
	public K key;
	public V value;

	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int hashCode() {
		return this.key.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		KeyValuePair<K, V> myNode = (KeyValuePair<K, V>) obj;
		
		return (this.key.equals(myNode.key));
	}
}
