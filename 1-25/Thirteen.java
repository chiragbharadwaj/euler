import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Thirteen {

	private Node list;

	public static void main(String[] args) {
		Thirteen thirteen = new Thirteen();
		System.out.println(thirteen.sum());
	}
	
	private String sum() {
		parse();
		BigInteger sum = BigInteger.ZERO;
		while (list.next != null) {
			sum = sum.add(list.value);
			list = list.next;
		}
		return sum.toString().substring(0, 10);
	}

	private void parse() {
		list = new Node();
		try (BufferedReader reader = new BufferedReader(new FileReader("src/Numbers.txt"))) {
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				list = list.add(new BigInteger(line), list);
			}
		} catch (IOException ex) {
			System.err.println("FileNotFoundException!");
		}
	}
	
	private class Node {
		private BigInteger value;
		private Node next;

		public Node() {
			this(null, null);
		}
		
		public Node(BigInteger value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		private Node add(BigInteger value, Node next) {
			Node node = new Node();
			node.value = value;
			node.next = next;
			return node;
		}
	}
}