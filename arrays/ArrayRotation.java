package arrays;
import java.util.Arrays;

public class ArrayRotation {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Original Array : " + Arrays.toString(a));
		leftRotateArray(a, 1);
		System.out.println("Left Rotation  : " + Arrays.toString(a));
		rightRotateArray(a, 1);
		System.out.println("Right Rotation : " + Arrays.toString(a));
		rightRotateArrayFromIToJ(a, 2, 4);
		System.out.println("Right Rotation : " + Arrays.toString(a));
	}

	private static void leftRotateArray(int[] arr, int k) {
		while (k > 0) {
			int temp = arr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			arr[arr.length - 1] = temp;
			k--;
		}
	}

	private static void rightRotateArray(int[] arr, int k) {
		while (k > 0) {
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 2; i >= 0; i--) {
				arr[i + 1] = arr[i];
			}
			arr[0] = temp;
			k--;
		}
	}

	private static void rightRotateArrayFromIToJ(int[] arr, int i, int j) {
		int temp = arr[j];
		for (int k = j - 1; k >= i; k--) {
			arr[k + 1] = arr[k];
		}
		arr[i] = temp;
	}

}
