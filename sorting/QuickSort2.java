package sorting;

import java.util.Arrays;

public class QuickSort2 {

	public static void main(String a[]) {
		int[] arr = {4,3,2,1,5};
		new QuickSort2().sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}

	public void sort(int[] a) {

		if (a == null || a.length == 0) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = a[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort(a, lowerIndex, j);
		if (i < higherIndex)
			quickSort(a, i, higherIndex);
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}