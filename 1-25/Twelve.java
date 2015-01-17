public class Twelve {

	public static void main(String[] args) {
		Twelve twelve = new Twelve();
		twelve.generateTriangularNumbers();
	}

	private void generateTriangularNumbers() {
		int n = 1;
		int num = 1;
		while (true) {
			if (numberDivisors(num) > 500) {
				System.out.print(num + " : " + numberDivisors(num));
				break;
			}
			n++;
			num = num + n;
		}
	}

	private int numberDivisors(int num) {
		int numberDivisors = 0;
		for (int n = 1; n <= Math.sqrt(num); n++) {
			if (num % n == 0) {
				if (num == n*n) {
					numberDivisors++; // Don't double-count this factor type!
				} else {
					numberDivisors = numberDivisors + 2; // Else count twice
				}
			}
		}
		return numberDivisors;
	}
}