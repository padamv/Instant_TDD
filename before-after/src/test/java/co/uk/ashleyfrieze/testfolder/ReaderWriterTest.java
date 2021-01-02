package co.uk.ashleyfrieze.testfolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReaderWriterTest {
	private File writtenFile;
	private File tempFolder;
	
	@Before
	public void setup() throws Exception{
		// with a temporary folder to write to
		tempFolder = File.createTempFile("tmp", "file");
		tempFolder.delete();
		tempFolder.mkdir();
	}
	
	@After
	public void teardown() throws Exception{
		
		// and they tidy up in successful
		assertTrue(writtenFile.delete());
		assertTrue(tempFolder.delete());
	}

	@Test
	public void readsLinesItWrote() throws Exception {
		// when we write the file
		List<String> someLines = Arrays.asList("One", "Two", "Three");
		writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);
		
		// then we can read it back
		List<String> readLines = ReaderWriter.read(writtenFile);
		
		// and they match
		assertEquals(someLines, readLines);
	}
	
	@Test
	public void readsZeroLinesItWrote() throws Exception {
		// when we write the file
		List<String> someLines = Arrays.asList();
		writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);
		
		// then we can read it back
		List<String> readLines = ReaderWriter.read(writtenFile);
		
		// and they match
		assertEquals(someLines, readLines);
	}

}
