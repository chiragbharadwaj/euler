public class Nine {
	public static void main(String[] args) {
		for (int x = 1; x <= 999; x++) {
			for (int y = 1; y <= 999; y++) {
				if (x * x + y * y == (1000 - x - y) * (1000 - x - y)) {
					System.out.println(x * y * (1000 - x - y));
					return;
				}
			}
		}
	}
}