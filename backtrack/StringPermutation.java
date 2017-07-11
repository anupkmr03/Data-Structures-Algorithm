package backtrack;

public class StringPermutation {
	public static void main(String[] args) {
		String str = "ABC";
		String[] split = str.split("");
		int x = split.length;
		permuteString(split, 0, x - 1);
	}

	public static void permuteString(String[] str, int p, int q) {
		if (p == q) {
			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i] + "");
			}
			System.out.println();
		}

		for (int i = p; i <= q; i++) {
			swapString(str, p, i);
			permuteString(str, p + 1, q);
			swapString(str, p, i);
		}
	}

	public static void swapString(String[] str, int i, int j) {
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

}