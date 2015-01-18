import java.math.BigInteger;
import java.util.ArrayList;

public class TwentyFive {
	
	private static ArrayList<BigInteger> fibonacci; // Memoized copy
	private static final int MAX_DIGITS = 1000;
	
	public static void main(String[] args) {
		TwentyFive twentyfive = new TwentyFive();
		twentyfive.run();
	}
	
	// Keeps running through the Fibonacci numbers (which have been memoized) until we reach
	// one with MAX_DIGITS. Prints out the term number of this Fibonacci number
	private void run() {
		initialize();
		int n = 2;
		while (true) {
			BigInteger F_n = fibonacci.get(n - 1).add(fibonacci.get(n - 2));
			fibonacci.add(F_n);
			if (F_n.toString().length() >= MAX_DIGITS) {
				System.out.println(n); // Print out the term number, not the Fibonacci number
				break;
			}
			n++;
		}
	}
	
	// Initializes the memory for Fibonacci-number memoization
	private void initialize() {
		fibonacci = new ArrayList<BigInteger>();
		fibonacci.add(new BigInteger("0")); // n = 0
		fibonacci.add(new BigInteger("1")); // n = 1
	}
}