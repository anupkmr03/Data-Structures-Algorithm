package arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		// int binarySearch = Arrays.binarySearch(a, 3);
		// System.out.println(binarySearch);

		new BinarySearch().doBinarySearch(a, 0, a.length - 1, 0);
	}

	public void doBinarySearch(int[] a, int low, int high, int data) {
		while (low <= high) {
			int mid1 = (low + high) / 2;
			if (a[mid1] < data) {
				low = mid1 + 1;
			} else if (a[mid1] > data) {
				high = mid1 - 1;
			} else {
				System.out.println(mid1);
				break;
			}
		}
		System.out.println(-1);
	}
}