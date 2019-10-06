import java.util.*; 

public class MatrixRotation { 

	
	static void reverseColumns(int a[][]) { 
		for (int i = 0; i < a[0].length; i++) {
			int start = 0;
			int end = a[0].length-1;

			while(start<=end){
			      antiClockWiseSwap(a,i,start,end);
			      start++;
			      end--;
			}
             	} 
	} 
  
  static void antiClockWiseSwap(int a[][], int k, int i, int j ){
   		int temp = a[i][k];
    		a[i][k] = a[j][k];
    		a[j][k] = temp;
  }
  static void clockWiseSwap(int a[][], int k, int i, int j ){
   		int temp = a[k][i];
    		a[k][i] = a[k][j];
    		a[k][j] = temp;
  }

	// Function for do transpose of matrix 
	static void transpose(int arr[][]) { 
		for (int i = 0; i < arr.length; i++) 
			for (int j = i; j < arr[0].length; j++) { 
				int temp = arr[j][i]; 
				arr[j][i] = arr[i][j]; 
				arr[i][j] = temp; 
			} 
	} 

	// Function for print matrix 
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 

	// Function to anticlockwise rotate 
	// matrix by 90 degree 
	static void rotate90(int arr[][]) 
	{ 
		transpose(arr); 
		reverseColumns(arr); 
	} 
	
	//**** Diff Approch for rotating matrix ******//
	private static void rotateAntiClockWiseOtherApproch(int[][] a, int n) {
        int noOfRotations = n / 2;
        n = n - 1;
        for (int i = 0; i < noOfRotations; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][n - i];
                a[j][n - i] = a[n - i][n - j];
                a[n - i][n - j] = a[n - j][i];
                a[n - j][i] = temp;
            }
        }
    }

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		int arr[][] = { { 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 } }; 

		rotate90(arr); 
		printMatrix(arr); 
	} 
} 
