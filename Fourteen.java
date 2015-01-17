public class Fourteen {
	
	private static final int MAX_LIMIT = 1000000;
	private int[] numberSteps; // Holds data for memoization purposes
	
	{
		numberSteps = new int[MAX_LIMIT + 1];
	}
	
	public static void main(String[] args) {
		Fourteen fourteen = new Fourteen();
		fourteen.generateSequence();
	}
	
	private long collatz(long copy) {
		if (copy % 2 == 0) {
			return copy / 2;
		} // else...
		return 3*copy + 1;
	}
	
	private void generateSequence() {
		int max = 0;
		int maxSteps = 0;
		for (int n = 1; n <= MAX_LIMIT; n++) {
			long copy = n;
			int steps = 0;
			while (copy != 1) {
				if (copy > 0 && copy < MAX_LIMIT && numberSteps[(int) copy] != 0) {
					steps = steps + numberSteps[(int) copy]; // Call from memory
					break;
				}
				copy = collatz(copy);
				steps++;
			}
			numberSteps[n] = steps;
			if (steps > maxSteps) {
				max = n; // Mark the starting number...
				maxSteps = steps; // ... and the number of steps
			}
		}
		System.out.println(max + " : " + maxSteps);
	}
}