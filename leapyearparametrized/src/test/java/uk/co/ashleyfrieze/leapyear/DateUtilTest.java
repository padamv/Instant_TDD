package uk.co.ashleyfrieze.leapyear;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateUtilTest {
	
	@Parameter(0)
	public int year;
	
	@Parameter(1)
	public boolean shouldBeLeap;
	
	@Parameters(name="The year {0, number,####} should have leap year as {1}")
	public static Object[][] parameters(){
		return new Object[][] {
			{1992, true},
			{1996, true},
			{1991, false},
			{1900, false},
			{2000, true}
		};
	}
	
	@Test
	public void isLeapYear() {
		assertThat(DateUtil.isLeapYear(year), is(shouldBeLeap));
	}
}
