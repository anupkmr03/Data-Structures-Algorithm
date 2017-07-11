package math;
public class CheckPowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo1(64));
	}
	static boolean isPowerOfTwo0(int x) {
		if (x == 0)
			return false;
		else {
			while (x % 2 == 0)
				x /= 2;
			return (x == 1);
		}
	}

	static boolean isPowerOfTwo1(int x) {
		// x will check if x == 0 and !(x & (x - 1)) will check if x is a power
		// of 2 or not
		return x==0?false:(x&(x-1))==0?true:false;
		
		/*if (x == 0)
			return false;
		else {
			int z = (x & (x - 1));
			if (z == 0) {
				return true;
			}
		}
		return false;*/
	}
}
