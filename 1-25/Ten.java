import java.math.BigInteger;

public class Ten {

	private static final int MAX_LIMIT = 2000000;
	private Node listOfPrimes;
	
	public static void main(String[] args) {
		Ten ten = new Ten();
		ten.generatePrimes();
		System.out.println(ten.sum());
	}
	
	private void generatePrimes() {
		listOfPrimes = new Node();
		
		boolean[] notPrime = new boolean[MAX_LIMIT];
		for (int i = 2; i <= Math.sqrt(MAX_LIMIT); i++) {
			if (notPrime[i] == false) {
				for (int j = i*i; j < MAX_LIMIT; j = j + i) {
					notPrime[j] = true;
				}
			}
		}
		
		for (int n = 2; n < notPrime.length; n++) {
			if (notPrime[n] == false) {
				listOfPrimes = listOfPrimes.add(n, listOfPrimes);
			}
		}
	}
	
	private BigInteger sum() {
		BigInteger sum = BigInteger.ZERO;
		while (listOfPrimes.next != null) {
			sum = sum.add(new BigInteger("" + listOfPrimes.value));
			listOfPrimes = listOfPrimes.next;
		}
		return sum;
	}
	
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
	}
}