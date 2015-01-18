import java.util.HashMap;
import java.util.Map;

public class TwentyOne {

	private static final int LIMIT = 10000;
	private Map<Integer, Integer> properSumMap;

	public static void main(String[] args) {
		TwentyOne twentyone = new TwentyOne();
		System.out.println(twentyone.sumOfAmicableNumbers());
	}

	// Returns the sum of all the amicable numbers under LIMIT, where a number M is "amicable" if
	// the sum of its proper divisors is the number N, where the sum of the proper divisors of N
	// is M in turn (i.e. amicable numbers come in pairs).
	private int sumOfAmicableNumbers() {
		generateMapping();
		int sum = 0;
		for (int n = 2; n < LIMIT; n++) {
			int num = properSumMap.get(n);
			if (num < LIMIT) { // Keep in bounds, obviously
				if (n != num & n == properSumMap.get(num)) {
					sum = sum + n;
				}
			} // else continue;
		}
		return sum;
	}

	// Creates a map that links each number under LIMIT to the sum of its proper factors
	private void generateMapping() {
		properSumMap = new HashMap<Integer, Integer>();
		properSumMap.put(1, 0); // The number "1" has exactly 0 proper factors
		for (int n = 2; n < LIMIT; n++) { // n = 1 doesn't count, as it has no proper divisors
			properSumMap.put(n, sumOfProperDivisors(n));
		}
	}

	// Returns a linked list containing all the proper divisors of parameter num
	private Node getProperDivisors(int num) {
		Node divisors = new Node();
		for (int n = 1; n <= Math.sqrt(num); n++) {
			if (num % n == 0) {
				divisors = divisors.add(n, divisors);
				if (num != n*n & n != 1) { // Don't double count, don't include num itself
					divisors = divisors.add(num/n, divisors);
				}
			}
		}
		return divisors;
	}

	// Returns the sum of all of the proper divisors of parameter num
	private int sumOfProperDivisors(int num) {
		Node divisors = getProperDivisors(num);
		int sum = 0;

		while (divisors.next != null) {
			sum = sum + divisors.value;
			divisors = divisors.next;
		}

		return sum;
	}

	// A linked list type of structure to hold Integer values
	private class Node {
		private Integer value;
		private Node next;

		public Node() {
			this(null, null);
		}

		public Node(Integer value, Node next) {
			this.value = value;
			this.next = next;
		}

		private Node add(Integer value, Node next) {
			Node node = new Node();
			node.value = value;
			node.next = next;
			return node;
		}

		// Prints it in a nice format: "[elem1,elem2,...,elemN]"
		public String toString() {
			String result = "[";		
			Node copy = this;
			while (copy.next != null) {
				result = result + copy.value + ",";
				copy = copy.next;
			}
			result = result.substring(0, result.length() - 1); // Cut off trailing ","
			result = result + "]";		
			return result;
		}
	}
}