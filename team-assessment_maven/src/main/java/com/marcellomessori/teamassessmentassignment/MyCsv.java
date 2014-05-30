package com.marcellomessori.teamassessmentassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

class MyCsv {
	private final URL csvPersonsFile;
	private String csvHeaderLine;
	private ArrayList<String> csvDataLines;

	public MyCsv(String csvPersonsFileName) throws FileNotFoundException, IOException {
		csvPersonsFile = getClass().getClassLoader().getResource(csvPersonsFileName);
		if (csvPersonsFile == null) {
			throw new FileNotFoundException("Error: could not find '" + csvPersonsFileName + "'.");
		}
		init(csvPersonsFile);
	}
	
	public String view() {
		return "Found " + csvPersonsFile;
	}

	String getHeaderString() {
		return csvHeaderLine;
	}

	private void init(URL csvPersonsFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPersonsFile.getPath()));
		
		csvHeaderLine = br.readLine();
		
		csvDataLines = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
			csvDataLines.add(line);
		}
	}
}
