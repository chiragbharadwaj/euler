public class Five {

	private static final int MAX_LIMIT = 20;

	public static void main(String[] args) {
		int result = 1;
		for (int n = 1; n < MAX_LIMIT; n++) {
			result = lcm(result, n);
		}
		System.out.println(result);
	}

	private static int lcm(int a, int b) {
		return ((a * b) / gcd(a, b));
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		if (b > a)
			return gcd(b, a);
		return gcd(b, a % b);
	}
}