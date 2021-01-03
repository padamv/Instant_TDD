package uk.co.ashleyfrieze.leapyear;

public class DateUtil {
	/**
	 * Is leap year
	 * @param year 4 digit year
	 * @return true if leap year
	 */
	public static boolean isLeapYear(int year) {

		return isDivisible(year, 4) && 
				(!isDivisible( year, 100) || 
				isDivisible(year, 400));
	}
	
	private static boolean isDivisible (int year, int divisor) {
		return year % divisor == 0;
	}
}
