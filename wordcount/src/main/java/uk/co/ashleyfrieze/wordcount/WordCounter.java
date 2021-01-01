package uk.co.ashleyfrieze.wordcount;

public class WordCounter {
	
	private int wordsSoFar = 0;

	public void add(String sentence) {
		if(!sentence.isEmpty()) {
			wordsSoFar += sentence.trim().split("\\s+").length;
		}
	}
	
	public int getUniqueWordsCount() {
		return wordsSoFar;
	}

}
