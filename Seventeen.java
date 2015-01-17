public class Seventeen {
	
	public static void main(String[] args) {
		Seventeen seventeen = new Seventeen();
		int sum = 0;
		for (int n = 1; n <= 1000; n++) {
			sum = sum + seventeen.numberLetters(seventeen.toWord(n));
		}
		System.out.println(sum);
	}
	
	// Brute force solution... fast enough, to be honest
	private String toWord(int num) {
		switch (num) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "forty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		case 1000:
			return "one thousand";
		default:
			break;
		}
		
		if (num < 100) { // Cannot be a units digit, as not caught by switch
			return toWord(10 * (num / 10)) + " " + toWord(num % 10);
		} else { // 100 <= num <= 1000 but not the cases above
			return toWord(num / 100) + ((num % 100 == 0) ? " hundred" : (" hundred and " + toWord(num % 100)));
		}
	}
	
	// Quick counting using regular expression-splitting
	private int numberLetters(String str) {
		String[] words = str.split(" ");
		int total = 0;
		for (String s : words) {
			total = total + s.length();
		}
		return total;
	}
}