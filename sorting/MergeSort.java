package sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1 };
		doMergeSort(a);
		System.out.println("Sorted array: " + Arrays.toString(a));

	}

	public static void doMergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int low, int high) {

		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[a.length];
		for (int i = low; i <= high; i++) {
			temp[i] = a[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				a[k++] = temp[i++];
			} else {
				a[k++] = temp[j++];
			}
		}

		while (i <= mid) {
			a[k++] = temp[i++];
		}
		while (j <= high) {
			a[k++] = temp[j++];
		}

	}

}
