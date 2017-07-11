package multi_dim_arrays;
public class MatrixRotation {
	public static void main(String[] args) {
		// int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 8, 9, 10, 11 }, { 12,
		// 13, 14, 15 } };
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] x = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(a);
		
		int[][] b = rotateAntiClockwise(a);
		print(b);
		 
		int[][] c = rotateClockwise(x);
		print(c);
	}

	public static int[][] rotateAntiClockwise(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = a[i][j];
				a[i][j] = a[j][n - i - 1];
				a[j][n - i - 1] = a[n - i - 1][n - j - 1];
				a[n - i - 1][n - j - 1] = a[n - j - 1][i];
				a[n - j - 1][i] = tmp;
			}
		}
		return a;
	}

	public static int[][] rotateClockwise(int[][] a) {
		int n = a.length;
		for (int i = 0; i <= n/ 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int p1 = a[i][j];
				int p2 = a[j][n - i - 1];
				int p3 = a[n - i - 1][n - j - 1];
				int p4 = a[n - j - 1][i];

				a[j][n - i - 1] = p1;
				a[n - i - 1][n - j - 1] = p2;
				a[n - j - 1][i] = p3;
				a[i][j] = p4;
			}
		}

		return a;
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print("[" + a[i][j] + "]" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}