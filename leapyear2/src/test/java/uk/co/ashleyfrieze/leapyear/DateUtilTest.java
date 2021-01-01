package uk.co.ashleyfrieze.leapyear;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void normalLEapYearisLeap() {
		assertTrue(DateUtil.isLeapYear(1992));
	}

	@Test
	public void normalLeapYearExample2IsLeap() {
		assertTrue(DateUtil.isLeapYear(1996));
	}
	
	@Test
	public void normalLEapYearisNotLeap() {
		assertFalse(DateUtil.isLeapYear(1991));
	}
	
	@Test
	public void centuryYearsAreNotLeap() {
		assertFalse(DateUtil.isLeapYear(1900));
	}
	
}
