import java.util.ArrayList;

public class Two {

	private static final int MAX_LIMIT = 4000000;
	private static ArrayList<Integer> fibonacci; // Memoized copy
	
	public static void main(String[] args) {
		
		fibonacci = new ArrayList<Integer>();
		fibonacci.add(1); // n = 0
		fibonacci.add(1); // n = 1
		
		int n = 2;
		int sum = 0;
		while (true) {
			int F_n = fibonacci.get(n - 1) + fibonacci.get(n - 2);
			fibonacci.add(F_n);
			if (F_n > MAX_LIMIT) break;
			if ((n - 2) % 3 == 0) {
				sum = sum + F_n;
			}
			n++;
		}
		System.out.println(sum);
	}
}