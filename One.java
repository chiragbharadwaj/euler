public class One {
	
	private static final int MAX_LIMIT = 1000;
	
	public static void main(String[] args) {
		int sum = 0;
		for (int n = 1; n < MAX_LIMIT; n++) {
			if (n % 3 == 0 | n % 5 == 0) {
				sum = sum + n;
			}
		}
		System.out.println(sum);
	}
}