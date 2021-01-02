package uk.co.ashleyfrieze;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTimeout {

	@Test(timeout = 100L)
	public void testThingThatMayRunForever() {
		assertEquals(42, someLongRoutine());
	}
	
	private static int someLongRoutine() {
		while(true) {
			// this will take forever
		}
	}

}
