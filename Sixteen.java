import java.math.BigInteger;

public class Sixteen {
	
	private static final BigInteger TWO = BigInteger.ONE.add(BigInteger.ONE);
	
	public static void main(String[] args) {
		char[] digits = digits();
		int sum = 0;
		for (int n = 0; n < digits.length; n++) {
			int digit = Integer.parseInt("" + digits[n]);
			sum = sum + digit;
		}
		System.out.println(sum);
	}
	
	private static char[] digits() {
		BigInteger number = TWO.pow(1000);
		return number.toString().toCharArray();
	}
}