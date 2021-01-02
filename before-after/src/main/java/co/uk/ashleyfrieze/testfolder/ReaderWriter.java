package co.uk.ashleyfrieze.testfolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class for persisting and reading bunch of strings
 *
 */
public class ReaderWriter {

	/**
	 * Writes the lines of the list to the target filename in the directory
	 * @param directory target directory
	 * @param fileName target filename
	 * @param lines lines of the file
	 * @return the file path of what was written
	 * @throws IOException on error
	 */
	public static File write(File directory, String filename, List<String> lines) throws IOException {
		
		File file = new File(directory, filename);
		try(FileWriter writer = new FileWriter(file)){
			for (String line : lines) {
				writer.write(line + "\n");
			}
		}
		return file;
	}
}
