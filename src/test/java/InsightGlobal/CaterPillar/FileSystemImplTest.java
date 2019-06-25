package InsightGlobal.CaterPillar;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

public class FileSystemImplTest {

	CSVReader csvr;

	@Before
	public void setUp() throws Exception {
		StringBuilder sb = new StringBuilder(CSVParser.INITIAL_READ_SIZE);
		sb.append("ShivaPrasad,Konduru").append("\n"); // standard case
		sb.append(",").append("\n");

		csvr = new CSVReader(new StringReader(sb.toString()));
	}

	@Test
	public void testParseLine() throws IOException {

		String[] nextLine = csvr.readNext();
		assertEquals("ShivaPrasad", nextLine[0]);
		assertEquals("Konduru", nextLine[1]);

		nextLine = csvr.readNext();
		assertEquals(2, nextLine.length);
	}

	@Test
	public void parseQuotedStringWithDefinedSeperator() throws IOException {
		StringBuilder sb = new StringBuilder(CSVParser.INITIAL_READ_SIZE);
		sb.append("chicago\tillinois").append("\n"); // tab separated case

		CSVReader c = new CSVReader(new StringReader(sb.toString()), '\t');

		String[] nextLine = c.readNext();
		assertEquals(2, nextLine.length);

	}
}
