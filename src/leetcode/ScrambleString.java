package leetcode;

import java.util.HashMap;

public class ScrambleString {
	/**
	 * Recursion + Hashing.
	 * Remember there are two cases: 1) swap the two
	 * children; or 2) not swap the two children, so we need s11, s12, and s21,
	 * s22, s31, s32 6 substrings.
	 */
	public boolean isScramble(String s1, String s2) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		return isScrambleHelper(s1, s2, map);
	}

	private boolean isScrambleHelper(String s1, String s2,
			HashMap<String, Boolean> map) {
		if (s1 == null || s2 == null) {
			return false;
		}

		if (s1.length() != s2.length()) {
			return false;
		}

		// Do not forget terminating case!!!
		if (s1.equals(s2)) {
			map.put(s1 + s2, true);
			return true;
		}

		if (map.containsKey(s1 + s2)) {
			return map.get(s1 + s2);
		}

		int len = s1.length();
		for (int i = 1; i < len; i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, len);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, len);
			String s31 = s2.substring(0, len - i);
			String s32 = s2.substring(len - i, len);

			if (isScrambleHelper(s11, s21, map)
					&& isScrambleHelper(s12, s22, map)) {
				map.put(s1 + s2, true);
				return true;
			}

			if (isScrambleHelper(s11, s32, map)
					&& isScrambleHelper(s12, s31, map)) {
				map.put(s1 + s2, true);
				return true;
			}
		}

		map.put(s1 + s2, false);
		return false;
	}
}
