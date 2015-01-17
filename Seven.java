public class Seven {

	private static final int UPPER_BOUND = 10001;

	public static void main(String[] args) {
		System.out.println(nthPrime(UPPER_BOUND));
	}

	private static int nthPrime(int n) {
		int num = 3;
		int temp;
		int count = 2;
		boolean test;

		while (count < n) {
			num += 2;
			temp = 3;
			test = true;
			while (temp <= (Math.sqrt(num))) {
				if (num % temp == 0) {
					test = false;
				}
				temp += 2;
			}
			if (test == true) {
				count++;
			}
		}
		return num;
	}
}