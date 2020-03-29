/*
 *code methods to learn the some simple number theory concepts
 */
public class PositiveInteger {
	//instance variables
	int num;
	
	//constructor
	public PositiveInteger(int number) {
		num = number;
	}
	
	//methods
	/*
	 * method that determines if the integer is perfect
	 */
	public boolean isPerfect() {
		int total = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				total = total + i;
			}
		}
		if (total == num) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * method that determines if the integer is abundant
	 */
	public boolean isAbundant() {
		int total = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				total = total + i;
			}
		}
		if (total > num) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*
	 * method that determines if the integer is narcissistic
	 */
	public boolean isNarcissistic() {
		String numToString = Integer.toString(num);
		double total = 0;
		for (int i = 0; i < numToString.length(); i++) {
			int IntegerDigit = Character.getNumericValue(numToString.charAt(i));
			total = total + Math.pow(IntegerDigit, numToString.length());
		}
		if (total == num) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		// test
		PositiveInteger myInteger = new PositiveInteger(371);
		System.out.println("The nunber you choose is perfect: " + myInteger.isPerfect());
		System.out.println("The nunber you choose is abundant: " + myInteger.isAbundant());
		System.out.println("The nunber you choose is narcissistic: " + myInteger.isNarcissistic());
	}
}
