package com.junit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.*;

import com.src.WordCounter;

public class WordCounterTest {

	@Test(expected = FileNotFoundException.class)
	public void testWordCounterFileNotFoundException() throws IOException, Exception {
		String filePath = "file.txt";
		WordCounter.wordCountHelper(filePath);
	}

	@Test(expected = IOException.class)
	public void testInvalidFileFormat() throws IOException, Exception {
		String filePath = "WelcomeScan.jpg";
		WordCounter.wordCountHelper(filePath);
	}

	@Test
	public void testWordCounterPositiveTest() throws IOException, Exception {
		String filePath = "testWordCounterPositiveTest.txt";
		assertEquals(3, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterPositiveContractionTest() throws IOException, Exception {
		String filePath = "testWordCounterPositiveContractionTest.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterPositiveContractionNextLine() throws IOException, Exception {
		String filePath = "testWordCounterPositiveContractionNextLine.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterPositivePunctuation() throws IOException, Exception {
		String filePath = "testWordCounterPositivePunctuation.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterUtfInvalidTest() throws IOException, Exception {
		String filePath = "testWordCounterUtfInvalidTest.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterNumberTest() throws IOException, Exception {
		String filePath = "testWordCounterNumberTest.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterNumberColonTest() throws IOException, Exception {
		String filePath = "testWordCounterNumberColonTest.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterPositivePossesiveTest() throws IOException, Exception {
		String filePath = "testWordCounterPositivePossesiveTest.txt";
		assertEquals(4, WordCounter.wordCountHelper(filePath));
	}

	@Test
	public void testWordCounterNegativeEmptyFileTest() throws IOException, Exception {
		String filePath = "testWordCounterNegativeEmptyFileTest.txt";
		assertEquals(0, WordCounter.wordCountHelper(filePath));
	}
	
	/**
	 *  Test to fail if it takes longer than a 100 milliseconds)
	 * @throws IOException
	 * @throws Exception
	 */
	@Test(timeout=100)
	public void testWordCounterPositivePossesivetimeoutTest() throws IOException, Exception {
		String filePath = "testWordCounterNegativeEmptyFileTest.txt";
		assertEquals(0, WordCounter.wordCountHelper(filePath));
	}
	
}
