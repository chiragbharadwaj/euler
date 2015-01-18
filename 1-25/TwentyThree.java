public class TwentyThree {

	private static final int LIMIT = 28123; // A hard limit, proved by analysis
	private Node abundantSumList;
	private boolean[] impermeable; // Minimum space in memory (!impermeable = deleteable)

	public static void main(String[] args) {
		TwentyThree twentythree = new TwentyThree();
		int result = twentythree.getAbundantSum();
		System.out.print(result);
	}

	// Returns the sum of all the numbers under LIMIT that cannot be represented by the sum of
	// any two abundant numbers in the abundantSumList
	private int getAbundantSum() {
		generateMapping();
		int sum = sum(1, LIMIT); // Sum from 1 to 23 + sum from 24 to the limit (partition logic)

		while (abundantSumList.next != null) {
			if (abundantSumList.value > LIMIT / 2) break;
			Node copy = abundantSumList; // Same principle at hand
			while (copy.next != null) {
				int value = abundantSumList.value + copy.value;
				if (value <= LIMIT && !impermeable[value]) {
					sum = sum - value; // Delete the values that CAN be written as such sums...
					impermeable[value] = true; // Cannot be deleted twice!
					// If we allowed for double-deletion, the values would wrap around
					// Integer.MIN_VALUE and re-create positive values! BAD BAD BAD
				}
				copy = copy.next;
			}
			abundantSumList = abundantSumList.next;
		}
		return sum; // ...which leaves the sum of the numbers that canNOT be written as such sums
	}

	// Returns a sum of the natural numbers from a to b (mathematically determined as below)
	//  ___________________________________________________________________________________
	// | S = (b)(b+1)/2 - (a-1)(a-1+1)/2 = (b)(b+1)/2 - (a-1)(a)/2 = (b^2 - a^2 + b + a)/2 |
	// |  = ((b+a)(b-a)+(b+a))/2 = ((b+a)(b-a+1))/2, which is what we have written below!  |
	//  ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
	private int sum(int a, int b) {
		return (b + a)*(b - a + 1)/2;
	}

	// Creates a linked list of all the abundant numbers under LIMIT
	private void generateMapping() {
		impermeable = new boolean[LIMIT+1]; // Allocate extra space for easy 1-indexing
		abundantSumList = new Node();
		for (int n = LIMIT; n >= 2; n--) { // n = 1 doesn't count, as it has no proper divisors
			if (sumOfProperDivisors(n) > n) {
				abundantSumList = abundantSumList.add(n, abundantSumList);
			}
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