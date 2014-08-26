package ctci.chapter11;

public class P115 {
	/**
	 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
	 * 
	 * Note: The trick is that, when the mid is "", move left and right, all the way to the point that we find a non-empty string.
	 */	
	public int binarySearch(String[] strings, String str) {
		if (strings == null || strings.length == 0 || str == null || str.equals("")) {
			return -1;
		}
		
		int start = 0;
		int end = strings.length - 1;
		int mid;
		
		while (start <= end) {
			mid = start + (end - start) / 2;			
			if (strings[mid].isEmpty()) {				
				for (int i = 0; i <= (end - start) / 2 + 1; i++) {
					if (mid - i < start || mid + i > end) {
						return -1;
					}
					
					if (!strings[mid + i].equals("")) {
						mid = mid + i;
						break;
					}
					
					if (!strings[mid - i].equals("")) {
						mid = mid - i;
						break;
					}
				}
			}
			
			if (strings[mid].compareTo(str) > 0) {
				end = mid - 1;
			}
			else if (strings[mid].compareTo(str) == 0) {
				return mid;
			}
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String[] strings = new String[]{"a", "", "b", "c", "", "", "", "d", "z"};

		P115 solver = new P115();
		
		System.out.println(solver.binarySearch(strings, "d"));
	}
	

}
