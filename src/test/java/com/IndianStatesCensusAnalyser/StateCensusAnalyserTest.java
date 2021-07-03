/************************************************************
 * Purpose : Test cases required to perform operations on CSV data
 * 
 * @author Piyush Shaw
 * @Version 1.0
 * @since 30-06-2021
 *
 ************************************************************/

package com.IndianStatesCensusAnalyser;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StateCensusAnalyserTest {
	public final String CSV_FILE_PATH = "C:\\Users\\PIYUSH\\eclipse-workspace\\IndianStatesCensusAnalyser\\src\\main\\java\\IndianStateCensus.csv";
	public final String WRONG_CSV_FILE_PATH = "C:\\Users\\PIYUSH\\eclipse-workspace\\IndianStatesCensusAnalyser\\src\\main\\java\\Contacts.csv";
	public final String WRONG_TYPE_FILE_PATH = "C:\\Users\\PIYUSH\\eclipse-workspace\\IndianStatesCensusAnalyser\\src\\main\\java\\Contacts.txt";

	private static StateCensusAnalyser censusAnalyser;

	@BeforeClass
	public static void createCensusAnalyserObj() {
		censusAnalyser = new StateCensusAnalyser();
	}

	// TC-1.1
	@Test
	public void givenStateCsvFile_CheckNumberOfRecords_ShouldReturnNumber() {
		try {
			int numberOfStates = censusAnalyser.loadCensusData(CSV_FILE_PATH);
			Assert.assertEquals(29, numberOfStates);
		} catch (Exception exception) {
			exception.getMessage();
		}
	}

	// TC-1.2
	@Test
	public void givenWrongStateCsvFile_CheckPresentOrNot_ShouldReturnException() {
		try {
			censusAnalyser.loadCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException exception) {
			Assert.assertEquals("file is not found", exception.getMessage());
		}
	}

	// TC-1.3
	@Test
	public void givenWrongTypeFile_CheckCsvOrNot_ShouldReturnCustomException() {
		try {
			censusAnalyser.loadCensusData(WRONG_TYPE_FILE_PATH);
		} catch (CensusAnalyserException exception) {
			Assert.assertEquals("file is not found", exception.getMessage());
		}
	}

	// TC-1.4
	@Test
	public void givenDelimiterErrorStateCsvFile_CheckPresentOrNot_ShouldReturnCustomException() {
		try {
			censusAnalyser.loadCensusData(CSV_FILE_PATH);
		} catch (CensusAnalyserException exception) {
			Assert.assertEquals("delimiter or header is improper", exception.getMessage());
		}
	}

	// TC-1.5
	@Test
	public void givenIndianCensusDataProper_WithImproperHeader_ShouldReturnCustomException() {
		try {
			censusAnalyser.loadCensusData(CSV_FILE_PATH);
		} catch (CensusAnalyserException exception) {
			Assert.assertEquals("delimiter or header is improper", exception.getMessage());
		}
	}
}
