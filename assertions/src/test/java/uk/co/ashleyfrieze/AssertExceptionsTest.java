package uk.co.ashleyfrieze;

import java.io.IOException;

import org.junit.Test;

public class AssertExceptionsTest {

	@Test(expected = IOException.class)
	public void willThrowThrows() throws Exception{
		willThrow();
	}
	
	private static void willThrow() throws IOException {
		throw new IOException("Bang");
	}

}
