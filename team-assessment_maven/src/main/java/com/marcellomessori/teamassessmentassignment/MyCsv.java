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
	private static final String CSV_SEPARATOR = ";";
	private static final String VERTICAL_DECORATOR = "|";
	private static final String VERTEX_DECORATOR = "+";
	private static final String HORIZONTAL_DECORATOR = "-";
	private int columnNumber;
	private int[] maxColWidths;

	public MyCsv(String csvPersonsFileName) throws FileNotFoundException, IOException {
		csvPersonsFile = getClass().getClassLoader().getResource(csvPersonsFileName);
		if (csvPersonsFile == null) {
			throw new FileNotFoundException("Error: could not find '" + csvPersonsFileName + "'.");
		}
		init(csvPersonsFile);
	}

	public String display() {
		StringBuilder formattedCsv = new StringBuilder();
		formattedCsv.append(getFormattedHeader());
		formattedCsv.append("\n");
		formattedCsv.append(getFormattedLineBreak());
		for (int lineNumber = 1; lineNumber < csvLines.size(); lineNumber++) {
			formattedCsv.append("\n");
			formattedCsv.append(getFormattedLine(lineNumber));
		}
		return formattedCsv.toString();
	}

	public String getFormattedHeader() {
		return getFormattedLine(0);
	}

	public String getFormattedRecord(int csvLineNumber) {
		return getFormattedLine(csvLineNumber);
	}

	public String getFormattedLineBreak() {
		StringBuilder decorateLine = new StringBuilder();
		for (int colWidth : maxColWidths) {
			decorateLine.append(String.format("%" + colWidth + "s", "").replace(" ", HORIZONTAL_DECORATOR));
			decorateLine.append(VERTEX_DECORATOR);
		}
		return decorateLine.toString();
	}

	private String getFormattedLine(int csvArrayIndex) {
		String[] items = csvLines.get(csvArrayIndex).split(CSV_SEPARATOR);

		StringBuilder decorateLine = new StringBuilder();
		for (int i = 0; i < maxColWidths.length; i++) {
			int maxWidth = Math.max(maxColWidths[i], items[i].length());
			decorateLine.append(String.format("%-" + maxWidth + "s", items[i]));
			decorateLine.append(VERTICAL_DECORATOR);
		}

		return decorateLine.toString();
	}

	private void init(URL csvPersonsFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPersonsFile.getPath()));

		storeLines(br);

		calculateColumnWidth();
	}

	private void calculateColumnWidth() {
		columnNumber = csvLines.get(0).split(CSV_SEPARATOR).length;
		maxColWidths = new int[columnNumber];
		for (int i = 0; i < maxColWidths.length; i++) {
			maxColWidths[i] = 0;

		}
		for (String csvLine : csvLines) {
			String[] cvsLineCols = csvLine.split(CSV_SEPARATOR);
			for (int column = 0; column < cvsLineCols.length; column++) {
				if (cvsLineCols[column].length() > maxColWidths[column]) {
					maxColWidths[column] = cvsLineCols[column].length();
				}
			}
		}
	}

	private void storeLines(BufferedReader br) throws IOException {
		csvLines = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
			csvLines.add(line);
		}
	}

}
