public class NumberConverter {

private static final String ZERO = "zero";
	private static final String NEGATIVE = "negative";
	private static final String HUNDRED = " hundred";
	
	public static void main(String[] args) {
		NumberConverter numberNames = new NumberConverter();
		System.out.println(-1+ " :: "+numberNames.int2Text(-1));
		System.out.println(0+ " :: "+numberNames.int2Text(0));
		System.out.println(1+ " :: "+numberNames.int2Text(1));
		System.out.println(1234567+ " :: "+numberNames.int2Text(1234567));
		System.out.println(900000001+ " :: "+numberNames.int2Text(900000001));
		System.out.println(9999912+ " :: "+numberNames.int2Text(9999912));

		
	}


	public String int2Text(int input) {
		/* holding the prefix text */
		String prefixText = "";
		/* holding the remaining text */
		String currentText = "";
		/* checking the place of the number for eg. 0-th place, 1-th place, 10-th place etc accordingly */
		int place = 0;

		/* Check to Handle Zero */
		if (input == 0) {
			return ZERO;
		}

		/* Check to Handle Negative Numbers */
		if (input < 0) {
			input = -input;
			prefixText = NEGATIVE;
		}
		
		/* loop through the number digits */
		do {
			int n = input % 1000;
			if (n != 0) {
				String text = convertLessThanOneThousand(n);
				currentText = text + Constants.specialNames[place]+","
						+ currentText;
			}
			place++;
			input /= 1000;
		} while (input > 0);
		
		// storing the final string.
		currentText = (prefixText + currentText).trim();
		// if at last index string contains , then check it and remove it.
		if(currentText.endsWith(",")){
			currentText = currentText.substring(0, currentText.length()-1);
		}
		
		// return the final converted text.
		return currentText;
		
	}

	/*
	 * Converting Numbers to English Words which are less than thousand.
	 */
	private String convertLessThanOneThousand(int number) {

		String currentText;
		/* Check number which are less then one thousand and convert it accordingly */
		if (number % 100 < 20) {
			currentText = Constants.numNames[number % 100];
			number /= 100;
		} else {
			currentText = Constants.numNames[number % 10];
			number /= 10;

			currentText = Constants.tensNames[number % 10]+"-"
					+ currentText.trim();
			number /= 10;
		}
		
		/* if number is zero return the current text */
		if (number == 0) {
			return currentText;
		}
		
		// return the final string with appending hundred and current text into it.
		return Constants.numNames[number] + HUNDRED + currentText;
	}



	static class Constants {

    public static final String[] specialNames = { "", " thousand", " million", " billion", " trillion", " quadrillion",
            " quintillion" };

    public static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
            " seventy", " eighty", " ninety" };

    public static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
            " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
            " seventeen", " eighteen", " nineteen" };

}
}
