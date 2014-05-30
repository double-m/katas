package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyCsvTest {

	private MyCsv myCsv;

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
	public void shoudReturnTheFormattedHeader() {
		String header = myCsv.getFormattedHeader();
		assertEquals("|Name     |Age|City     |", header);
	}

	@Test
	public void shoudReturnAFormattedDataLine() {
		String header = myCsv.getFormattedRecord(5);
		assertEquals("|Yuri     |23 |Moscow   |", header);
	}

	@Test
	public void shoudReturnTheFormattedLineBreak() {
		String header = myCsv.getFormattedLineBreak();
		assertEquals("+---------+---+---------+", header);
	}

	@Ignore
	public void nextTest() {

	}
}
