package string;
public class LongestPalindromeFinder {

	public static void main(String[] args) {
		System.out.println(longestPalindromeString("1234"));
		System.out.println(longestPalindromeString("12321"));
		System.out.println(longestPalindromeString("abb"));
	}

	static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right)
			return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	// O(n^2)
	public static String longestPalindromeString(String s) {
		if (s == null)
			return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			// odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			// even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

}