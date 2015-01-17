import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** This is the EXACT same program as Eighteen, except the number of rows is now 100. DP! */
public class SixtySeven {

	public static final int MAX_ENTRIES = 100;

	public static void main(String[] args) {
		SixtySeven sixtyseven = new SixtySeven();
		sixtyseven.generatePath();
	}

	private int[][] parse() {
		int[][] matrix = new int[MAX_ENTRIES][MAX_ENTRIES];
		try (BufferedReader reader = new BufferedReader(new FileReader("src/TriangleExtended.txt"))) {
			int i = 0;
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					assert (i == MAX_ENTRIES);
					break;
				}
				String[] entries = line.split(" ");
				for (int j = 0; j <= i; j++) {
					matrix[i][j] = Integer.parseInt(entries[j]);
				}
				i++;
			}
		} catch (IOException ex) {
			System.err.println("FileNotFoundException!");
		}
		return matrix;
	}

	// Bottom-up strategy!
	private void generatePath() {
		int[][] matrix = parse();

		int[] maximaList = new int[matrix[0].length];

		// Initialize the list of maximas by starting at the bottom row and developing "maxima"s
		for (int k = 0; k < matrix[0].length; k++) {
			maximaList[k] = matrix[matrix[0].length-1][k];
		}

		// Dynamically scaling upward and repeating the process above but only taking the maxima
		// as needed with Math.max--dynamically solves the problem and is SCALABLE (see #67)
		// Note--start at matrix[0].length - 2 because we ALREADY DID THE BOTTOM ROW ABOVE
		for (int i = matrix[0].length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				maximaList[j] = matrix[i][j] + Math.max(maximaList[j], maximaList[j+1]);
			}
		}

		System.out.println("The maximum path sum is " + maximaList[0]);
	}
}