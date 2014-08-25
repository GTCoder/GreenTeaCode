package ctci.chapter8;

public class P810 {

	public static void main(String[] args) {
		Hash<String, Integer> myHashMap = new Hash<String, Integer>(10);
		myHashMap.put("key1", 1);
		myHashMap.put("key1", 1);
		myHashMap.put("key2", 2);
		myHashMap.put("key3", 3);
		
		String key;
		key = "key1";
		System.out.println(String.format("Get %s: %d", key, myHashMap.get(key)));
		
		key = "key2";
		System.out.println(String.format("Get %s: %d", key, myHashMap.get(key)));
		
		key = "key3";
		System.out.println(String.format("Get %s: %d", key, myHashMap.get(key)));
	}

}
