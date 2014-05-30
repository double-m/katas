package com.marcellomessori.teamassessmentassignment;

import java.io.FileNotFoundException;
import java.net.URL;

class MyCsv {
	private final URL csvPersonsFile;

	public MyCsv(String csvPersonsFileName) throws FileNotFoundException {
		csvPersonsFile = getClass().getClassLoader().getResource(csvPersonsFileName);
		if (csvPersonsFile == null) {
			throw new FileNotFoundException("Error: could not find '" + csvPersonsFileName + "'.");
		}
	}
	
	public String view() {
		return "Found " + csvPersonsFile;
	}

}
