public class Six {
	
	private static final int N = 100;
	
	public static void main(String[] args) {
		System.out.println(Math.abs(sum(N)*sum(N) - sumSquares(N)));
	}
	
	private static int sum(int n) {
		return n * (n + 1) / 2;
	}

	private static int sumSquares(int n) {
		return n * (n + 1) * (2 * n + 1) / 6;
	}
}