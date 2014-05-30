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
	public void shoudReturnAnHeaderFileCOntainingTheBasicFields() {
		String header = myCsv.getHeaderString();
		assertTrue(header.contains("Name"));
		assertTrue(header.contains("Age"));
		assertTrue(header.contains("City"));
	}

	@Ignore
	public void nextTest() {

	}
}
