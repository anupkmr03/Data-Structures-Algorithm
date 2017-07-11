package sorting;

import java.util.Arrays;

// coreman implementation
public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 4, 5, 4 };
		new QuickSort().quickSort(a, 0, a.length);
		print(a);
	}

	public void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q);
			quickSort(a, q + 1, r);
		}
	}

	public int partition(int[] a, int p, int r) {
		int i = p;
		for (int j = p; j < r - 1; ++j) {
			if (a[j] <= a[r - 1]) {
				swap(a, i, j);
				++i;
			}
		}
		swap(a, i, r - 1);
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void print(int[] a) {
		System.out.println("Sorted array: " + Arrays.toString(a));
	}

}
