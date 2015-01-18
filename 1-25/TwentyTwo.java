import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TwentyTwo {
	
	private String[] names;
	
	public static void main(String[] args) {
		TwentyTwo twentytwo = new TwentyTwo();
		twentytwo.run();
	}
	
	// Container function for tie-together readability
	private void run() {
		parseNames();
		
		int sum = 0;
		for (String name : names) {
			sum = sum + getTotalScore(name);
		}
		
		System.out.println(sum); // Prints out the total name score, as needed
	}
	
	// Parses the files of names and stores them in an array of size ~5000
	private void parseNames() {
		try (BufferedReader reader = new BufferedReader(new FileReader("src/Names.txt"))) {
			String line = reader.readLine();
			names = line.split("\",\""); // Regex organization--removes most quotation marks!
			
			// Some minor touches need to be made to the first and last element, however
			names[0] = names[0].substring(1);
			String temp = names[names.length - 1];
			names[names.length - 1] = temp.substring(0, temp.length()-1);
		} catch (IOException ex) {
			names = new String[0]; // Empty initialization
			System.err.println("FileNotFoundException!");
		}
		sort(0, names.length);
	}
	
	// Sorts the names in alphabetical order using a quick sort (best for distinct elements)
	private void sort(int l, int r) {
		if (l == r | l == r-1) { // An array of length 0 or 1: nothing to sort!
			return;
		}
		int k = partition(l,r);
		sort(l,k);
		sort(k,r);
		// Recursive calls!
	}
	
	// Partitions the list to be sorted as needed for a quick sort
	private int partition(int l, int r) {
		// Smarter move is to first trade off names[l] with some random element a[d], d is random
		String p = names[l]; // Pivot (there is at least one element >= p by definition)
		int i = l, j = r;
		
		do {
			j--;
		} while (names[j].compareTo(p) > 0);
		
	    while (i < j) { // Breaks upon i >= j
	        String anotherTemp = names[i]; // More swapping
	        names[i] = names[j];
	        names[j] = anotherTemp;
	        do {
	        	i++;
	        } while (names[i].compareTo(p) < 0);
	        do {
	        	j--;
	        } while (names[j].compareTo(p) > 0);
	    }
	    return j+1;
	}
	
	// Searches the sorted array for k using binary search, returns the element's index + 1
	private int search(String k) {
	    int l = 0;
	    int r = names.length-1;
	    
	    while (l < r) {
	    	int m = (l+r)/2; // Split in half and search by divide-and-conquer
	    	if (k.compareTo(names[m]) <= 0) {
	    		r = m;
	    	} else {
	    		l = m+1;
	    	}
	    }
	    return l+1; // Returns index+1 for scoring purposes
	}
	
	// Gets the score associated with a name by summing letters ('A'=1,'B'=2,...,'Z'=26)
	private int getNameScore(String name) {
		int score = 0;
		for (int n = 0; n < name.length(); n++) {
			score = score + (name.charAt(n) - 'A' + 1); // Score from 1 to 26
		}
		return score;
	}
	
	// Returns the total score associated with a name by computing the inner product of
	// its alphabetical rank and its name score (see above)
	private int getTotalScore(String name) {
		return getNameScore(name) * search(name);
	}
}