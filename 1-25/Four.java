public class Four {
	
	private static int largestPalindrome = 100001;
	
	public static void main(String[] args) {
		for (int x = 100; x < 1000; x++) {
			for (int y = 100; y < 1000; y++) {
				int product = x*y;
				if (isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		System.out.println(largestPalindrome);
	}
	
    private static boolean isPalindrome(int num) {
    	String s = Integer.toString(num);
        return s.equals(reverse(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}