package string;

public class RunLengthEncoding {
	
	public static void main(String[] args) {
		String output = RunLengthEncoding.runLengthEncoding("wwwtttpppppqqrrrrrw");
		System.out.println(output);
	}
	
	public static String runLengthEncoding(String text) {
	    String encodedString = "";

	    for (int i = 0, count = 1; i < text.length(); i++) {
	        if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
	            count++;
	        else {
	            encodedString = encodedString.concat(Character.toString(text.charAt(i))
	                    .concat(Integer.toString(count)));
	            count = 1;
	        }
	    }
	    return encodedString;
	}
}
