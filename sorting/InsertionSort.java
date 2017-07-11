package sorting;

import java.util.Arrays;

public class InsertionSort {
		
	
	public static void main(String[] args) {
		int[] ar = {4,3,2,1};
		int[] doInsertionSort = doInsertionSort(ar);
		print(doInsertionSort);
	}
	
	public static int[] doInsertionSort(int[] a){
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i-1;
			while(j>=0 && temp < a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
		
		return a;
	}
	public static void print(int[] a){
		System.out.println("Sorted array: " + Arrays.toString(a));
	}
}