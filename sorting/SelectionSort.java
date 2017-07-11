package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1 };
		new SelectionSort().doSelectionSort(a);
	}

	public void doSelectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, i, min);
		}

		print(a);
	}

	private void print(int[] a) {
		System.out.print("Sorted array: "+Arrays.toString(a));

	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
