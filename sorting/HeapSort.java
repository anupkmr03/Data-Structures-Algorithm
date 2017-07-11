package sorting;

import java.util.Arrays;

public class HeapSort {
	private static int heap_size;

	public static void main(String[] args) {
		int[] a = { 5, 4, 3, 2, 2, 2, 1 };
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(a);
		heapSort.print(a);

	}

	public void heapSort(int[] a) {
		buildHeap(a);
		for (int i = heap_size; i > 0; i--) {
			swap(a, 0, i);
			heap_size--;
			maxHeapify(a, 0);
		}
	}
	private void buildHeap(int[] a) {
		heap_size = a.length - 1;
		for (int i = heap_size / 2; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}
	private void maxHeapify(int[] a, int i) {
		int left = 2 * i;
		int right = (2 * i) + 1;
		int max = i;
		if (left <= heap_size && a[left] > a[i])
			max = left;
		else
			max = i;

		if (right <= heap_size && a[right] > a[max])
			max = right;

		if (max != i) {
			swap(a, i, max);
			maxHeapify(a, max);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void print(int[] a) {
		System.out.println("Sorted array: " + Arrays.toString(a));

	}

}
