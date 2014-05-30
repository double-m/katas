package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyCsvTest {

	private MyCsv myCsv;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Before
	public void setUp() throws FileNotFoundException, IOException {
		myCsv = new MyCsv("persons.csv");
	}

	@Test
	public void shoudReturnFileNotFoundExceptionWhenItCannotFindTheSourceFile() throws IOException {
		try {
			new MyCsv("nonExistingFile.csv");
			fail("Should have thrown a FileNotFoundException.");
		} catch (FileNotFoundException e) {
			assertEquals(true, true);
		}
	}

	@Test
	public void shoudReturnAFormattedSubsetOfRecords() {
		StringBuilder expectedDisplay = new StringBuilder();
		expectedDisplay.append("Name |Age|City    |");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("-----+---+--------+");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Peter|42 |New York|");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Paul |57 |London  |");
		expectedDisplay.append(LINE_SEPARATOR);
		expectedDisplay.append("Mary |35 |Munich  |");
		assertEquals(expectedDisplay.toString(), myCsv.display(3));
	}

	@Ignore
	public void nextTest() {

	}
}
