package com.marcellomessori.teamassessmentassignment;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyCsvTest {

    @Before
    public void setUp() {
    }

	@Test
	public void shoudReturnFileNotFoundExceptionWhenItCannotFindTheSourceFile() {
		try {
			new MyCsv("nonExistingFile.csv");
			fail("Should have thrown a FileNotFoundException.");
		}
		catch (FileNotFoundException e) {
			assertEquals(true, true);
		}
	}

	@Ignore
	public void nextTest() {
		
	}
}
