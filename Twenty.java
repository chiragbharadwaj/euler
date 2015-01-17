import java.math.BigInteger;

public class Twenty {
	
	private static final BigInteger NUMBER = new BigInteger("100");
	
	public static void main(String[] args) {
		Twenty twenty = new Twenty();
		twenty.sum();
	}
	
	private void sum() {
		BigInteger number = factorial(NUMBER);
		BigInteger sum = BigInteger.ZERO;
		
		while (true) { // Loops until we hit the total number of digits
			if (number.equals(BigInteger.ZERO)) { // We have divided through all the digits!
				break;
			}
			BigInteger digit = number.mod(new BigInteger("10"));
			if (!digit.equals(BigInteger.ZERO)) { // Wastes less computation time
				sum = sum.add(digit);
			}
			number = number.divide(new BigInteger("10")); // Keep dividing by 10 to shift over
		}		
		
		System.out.println(sum);
	}
	
	private BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return n.multiply(factorial(n.subtract(BigInteger.ONE))); // n*(n-1)! recursively
	}
}