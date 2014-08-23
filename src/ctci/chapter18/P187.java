package ctci.chapter18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 18.7 Given a list of words, write a program to find the longest word made of
 * other words in the list.
 * 
 * @author Dongye
 * 
 */
public class P187 {
	Map<String, Boolean> dict = new HashMap<String, Boolean>();

	public P187() {

	}

	public String getLongestWord(String[] words) {

		// A comparator in reverse order
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				if (word1.length() < word2.length()) {
					return 1;
				}
				else if (word1.length() == word2.length()) {
					return 0;
				}
				else {
					return -1;
				}
			}
		};

		for (String word : words) {
			dict.put(word, true);
		}

		Arrays.sort(words, comp);

		for (String word : words) {
			if (isMadeOfWords(word, dict, true)) {
				return word;
			}
		}

		return "";
	}

	public boolean isMadeOfWords(String word, Map<String, Boolean> dict,
			boolean isOriginal) {
		// If word is among the original words, the it must be true, and it is
		// meaningless to return true for itself, so we use isOriginal
		if (dict.containsKey(word) && !isOriginal) {
			return dict.get(word);
		}

		for (int i = 1; i < word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i);
			if (dict.containsKey(left) && dict.get(left)
					&& isMadeOfWords(right, dict, false)) {
				dict.put(word, true);
				return true;
			}
		}

		dict.put(word, false);
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = new String[] { "abc", "def", "abcdef", "abccddfdbb",
				"ae", "abcae" };

		P187 tester = new P187();
		System.out.println(tester.getLongestWord(words));

	}

}
