package math;

public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println(isPrime(1000000008) ? "Prime" : "Not prime");
		System.out.println(isPrime(1000000009) ? "Prime" : "Not prime");

	}
	
	
	public static boolean isPrime(int n) {
		if (n == 1)  
			return false;
		else if (n == 2) // if 2 it is even return true
			return true;
		else if ((n & 1) == 0) // to check number is even or not if even return false
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) { // only check with odd number of elements.
			if (n % i == 0) {
				return false;
			}
		}
		return true; 
	}
}
