package co.uk.ashleyfrieze.testfolder;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertTrue;

public class ReaderWriterTempFolderTest {
	private File writtenFile;
	
	@ Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@After
	public void ensureFileIsGone() {
		assertTrue(writtenFile.delete());
	}
	
    @Test
    public void readsLinesItWrote() throws Exception {
        // when we write the file
        List<String> someLines = asList("One", "Two", "Three");
        writtenFile = ReaderWriter.write(temporaryFolder.getRoot(), "MyFile", someLines);

        // then we can read it back
        List<String> readLines = ReaderWriter.read(writtenFile);

        // and they match
        assertEquals(someLines, readLines);

    }
}