package uk.co.ashleyfrieze.leapyear;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void normalLeapYearIsLeap() {
		assertTrue(DateUtil.isLeapYear(1992));
	}
	@Test
	public void normalLeapYearIsLeap2() {
		assertTrue(DateUtil.isLeapYear(1996));
	}
	
	@Test
	public void nonLeapYearIsNotLeap() {
		assertFalse(DateUtil.isLeapYear(1991));
	}

}
