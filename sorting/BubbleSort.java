package sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] array = { 12, 35, 87, 26, 9, 28, 7 };
		bubbleSort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}

	public static void bubbleSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		int n = array.length;
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int j = 1; j < n; j++) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
					swapped = true;
				}
			}
			n--; // nth element placed at correct position, so next iteration
					// needs to be done till n-1th element
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}