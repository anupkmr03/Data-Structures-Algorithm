package stack;

import java.util.Stack;

public class BalancedParentheses { 
	static char openToken[] = { '(', '{', '[' };
	static char closeToken[] = { ')', '}', ']' };

	public static boolean checkOpenToken(char c) {
		if (c == openToken[0] || c == openToken[1] || c == openToken[2])
			return true;
		else
			return false;
	}

	private static char checkCloseToken(char x) {
		if (x == openToken[0])
			return closeToken[0];
		else if (x == openToken[1])
			return closeToken[1];
		else
			return closeToken[2];
	}

	public static boolean isBalanced(String expression) {
		char[] ca = expression.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : ca) {
			if (checkOpenToken(c)) {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					char x = stack.pop();
					if (checkCloseToken(x) != c) {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String expression = "{{[[(())]]}}";
		System.out.println((isBalanced(expression)) ? "YES" : "NO");

		String expression2 = "{[(])}";
		System.out.println((isBalanced(expression2)) ? "YES" : "NO");
	}
}
