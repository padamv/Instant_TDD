package uk.co.ashleyfrieze.wordcount;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordCounterTest {
	private WordCounter counter = new WordCounter();

	@Test
	public void emptyStringHasNoWords() {
		counter.add("");
		assertEquals(0, counter.getUniqueWordsCount());
	}

}
