import java.util.*; 

public class MatrixRotation { 

	
	static void reverseColumns(int a[][]) 
	{ 
		for (int i = 0; i < a[0].length; i++) 
        {
        	int start = 0;
            int end = a[0].length-1;
          	
          	while(start<=end){
              swap2(a,i,start,end);
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
	static void transpose(int arr[][]) 
	{ 
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
