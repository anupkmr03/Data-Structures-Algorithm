package bit;

public class BitwiseAddition {
	public static void main(String[] args) {
		BitwiseAddition obj = new BitwiseAddition();
		int addNums = obj.addNums(3, 5);
		System.out.println(addNums);
	}
	public int addNums(int x,int y){
		 // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
}
