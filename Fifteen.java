import java.math.BigInteger;

/**
 * I worked this one out on paper using trees and figured out that it was a
 * combinatoric relationship between the total number of paths and the degrees
 * of freedom in terms of movement. This is a (very) simple implementation.
 */

public class Fifteen {

	private static final BigInteger NUMBER_ROWS = new BigInteger("20");

	// We seek the (NUMBER_ROWS)th central binomial coefficient
	// factorial(2*NUMBER_ROWS) / ((factorial(NUMBER_ROWS))*(factorial(NUMBER_ROWS)));
	public static void main(String[] args) {
		BigInteger TWO = BigInteger.ONE.add(BigInteger.ONE);
		BigInteger NUMERATOR = factorial(NUMBER_ROWS.multiply(TWO));
		BigInteger DENOMINATOR = factorial(NUMBER_ROWS).multiply(factorial(NUMBER_ROWS));
		BigInteger numberRoutes = NUMERATOR.divide(DENOMINATOR);
		System.out.println(numberRoutes);
	}

	private static BigInteger factorial(BigInteger num) {
		if (num.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		return num.multiply(factorial(num.subtract(BigInteger.ONE)));
	}
}