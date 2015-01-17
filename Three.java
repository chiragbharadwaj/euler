public class Three {
	public static void main(String[] args) {
		long largestPrimeFactor = 0;
		long m = 600851475143L;
		for (long n = 3; n < m; n += 2) {
			while (m % n == 0) {
				largestPrimeFactor = n;
				m = m / n;
			}
		}
		System.out.println((m == 1) ? largestPrimeFactor : m);
	}
}