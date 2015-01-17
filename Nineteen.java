public class Nineteen {
	
	public static void main(String[] args) {
		findNumberSundays();
	}

	
	private static void findNumberSundays() {
		Days day = Days.MONDAY; // Jan 1, 1900 was a Monday
		int count = 0;
		
		for (int year = 1900; year <= 2000; year++) {			
			boolean notLeapYear = isNotLeapYear(year);		
			for (Months month : Months.values()) {
				if (year != 1900 && day == Days.SUNDAY) { // We only count from 1901, remember!
					count++;
				}
				if (month != Months.FEBRUARY | notLeapYear) { // Special case-handling
					day = getDay((day.num + (month.days % 7)) % 7);
				} else { // month == FEBRUARY in a leap year
					day = getDay((day.num + (29 % 7)) % 7); // FEBRUARY has 29 days in leap years
				}
			}
		}
		System.out.println("The total number of Sundays that fell on the first"
				+ " of a month between 1901 and 2000 is " + count + ".");
	}
	
	// Determines if a given year number is NOT a leap year according to Gregorian calendar rules
	private static boolean isNotLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 != 0) {
				return false;
			} else {
				if (year % 400 == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	// Gets the enum type day corresponding to a given number 0 through 6
	private static Days getDay(int num) {
		switch (num) {
		case 0:
			return Days.MONDAY;
		case 1:
			return Days.TUESDAY;
		case 2:
			return Days.WEDNESDAY;
		case 3:
			return Days.THURSDAY;
		case 4:
			return Days.FRIDAY;
		case 5:
			return Days.SATURDAY;
		case 6:
			return Days.SUNDAY;
		default:
			return null;
		}
	}
	
	// Enumerates the Month type so we can access it easier
	private enum Months {
		
		JANUARY   (31),
		FEBRUARY  (28),
		MARCH     (31),
		APRIL     (30),
		MAY       (31),
		JUNE      (30),
		JULY      (31),
		AUGUST    (31),
		SEPTEMBER (30),
		OCTOBER   (31),
		NOVEMBER  (30),
		DECEMBER  (31);
		
		private final int days;
		
		Months(int days) {
			this.days = days;
		}
	}
	
	private enum Days {
		
		MONDAY    (0),
		TUESDAY   (1),
		WEDNESDAY (2),
		THURSDAY  (3),
		FRIDAY    (4),
		SATURDAY  (5),
		SUNDAY    (6);
		
		private final int num;
		
		Days(int num) {
			this.num = num;
		}
	}
}