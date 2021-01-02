package co.uk.ashleyfrieze.testfolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReaderWriterTest {

	@Test
	public void readsLinesItWrote() throws Exception {
		// with a temporary folder to write to
		File tempFolder = File.createTempFile("tmp", "file");
		tempFolder.delete();
		tempFolder.mkdir();
		
		// when we write the file
		List<String> someLines = Arrays.asList("One", "Two", "Three");
		File writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);
		
		// then we can read it back
		List<String> readLines = ReaderWriter.read(writtenFile);
		
		// and they match
		assertEquals(someLines, readLines);
		
		// and they tidy up in successful
		assertTrue(writtenFile.delete());
		assertTrue(tempFolder.delete());
	
	}

}
