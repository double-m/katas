package com.marcellomessori.teamassessmentassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

class MyCsv {

	private final URL csvPersonsFile;
	private ArrayList<String> csvLines;

	public MyCsv(String csvPersonsFileName) throws FileNotFoundException, IOException {
		csvPersonsFile = getClass().getClassLoader().getResource(csvPersonsFileName);
		if (csvPersonsFile == null) {
			throw new FileNotFoundException("Error: could not find '" + csvPersonsFileName + "'.");
		}
		init(csvPersonsFile);
	}

	public String display() {
		return display(csvLines.size() - 1);
	}

	public String display(int linesPerPage) {
		return display(linesPerPage, 1);
	}

	public String display(int linesPerPage, int pageNumber) {
		int[] displayRange = calculateDisplayRange(linesPerPage, pageNumber);

		DecoratedTableWithHeader decoratedTable = new DecoratedTableWithHeader();
		decoratedTable.addCsvLine(csvLines.get(0));
		for (int lineNumber = displayRange[0]; lineNumber <= displayRange[1]; lineNumber++) {
			decoratedTable.addCsvLine(csvLines.get(lineNumber));
		}

		return decoratedTable.display();
	}

	private int[] calculateDisplayRange(int linesPerPage, int pageNumber) {
		int recordTotal = csvLines.size() - 1;
		int numberOfRecordToDisplay = Math.min(linesPerPage, recordTotal);
		int firstPageNumber = 1;
		int lastPageNumber = recordTotal / numberOfRecordToDisplay;
		if (recordTotal % numberOfRecordToDisplay > 0) {
			lastPageNumber += 1;
		}
		int numberOfThePageToDisplay = Math.min(pageNumber, lastPageNumber);
		numberOfThePageToDisplay = Math.max(numberOfThePageToDisplay, firstPageNumber);
		int startingLineToDisplay = (numberOfThePageToDisplay - 1) * numberOfRecordToDisplay + 1;
		int endingLineToDisplay = Math.min(numberOfThePageToDisplay * numberOfRecordToDisplay, recordTotal);
		int[] firstAndLastRecordToDisplay = { startingLineToDisplay, endingLineToDisplay };
		return firstAndLastRecordToDisplay;
	}

	private void init(URL csvPersonsFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPersonsFile.getPath()));

		storeLines(br);
	}

	private void storeLines(BufferedReader br) throws IOException {
		csvLines = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
			csvLines.add(line);
		}
	}

}
