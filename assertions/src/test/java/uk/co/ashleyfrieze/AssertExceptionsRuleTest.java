package uk.co.ashleyfrieze;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertExceptionsRuleTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void willThrowError() throws Exception {
		expectedException.expect(IOException.class);
		expectedException.expectMessage("ang");
		willThrow();
	}

	private static void willThrow() throws IOException {
		throw new IOException("Bang");
	}

}
