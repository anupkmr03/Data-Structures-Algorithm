package math;
public class GCD {
	public static void main(String[] args) {
		System.out.println(calculateGcd(81,153));
	}
	
	public static int calculateGcd(int num1, int num2){
		while(num2!=0){
			int temp = num2;
			num2 = num1%num2;
			num1  = temp;
		}
		return num1;
	}
}