import java.util.List;
import java.util.ArrayList;

public class TwentyFour {
	
	private List<Integer> availableDigits;
	private String digits;
	private static final int LIMIT = 1000000;
	// The one-millionth permutation will be the number that comes 999999th in the sequence
	// 0123456789, 0123456798, 0123456879, 0123456897, ... , 9876543201, 9876543210
	// (Note that it is zero-indexed)
	
	public static void main(String[] args) {
		TwentyFour twentyfour = new TwentyFour();
		twentyfour.findDigits();
	}
	
	// Finds the digits in the prescribed order for the number to be 999999th in sequence
	private void findDigits() {
		initialize();
		int limit = LIMIT-1; // The 999999th in sequence, i.e. LIMIT-1
		for (int n = 9; n >= 0; n--) {
			int count = 0;
			int factor = factorial(n);
			while (limit >= 0) {
				limit = limit - factor;
				count++;
				if (limit < 0) { // Prevents late loop guard effects
					limit = limit + factor;
					count--;
					break;
				}
			}
			assert (count >= 0 & count < n); // Necessary check to prevent out-of-bounds errors
			digits = digits + availableDigits.get(count);
			availableDigits.remove(count); // This digit is no longer available in permutation
		}
		System.out.println(digits);
	}
	
	// Initializes the list of available digits to {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	private void initialize() {
		availableDigits = new ArrayList<Integer>();
		digits = "";
		for (int n = 0; n <= 9; n++) {
			availableDigits.add(n);
		}
	}
	
	// Returns n!, where n! = n(n-1)(n-2)...(3)(2)(1)
	private int factorial(int n) {
		if (n == 0 | n == 1) { // 0! = 1! = 1
			return 1;
		}
		return n*factorial(n-1); // n*(n-1)! recursively
	}
}