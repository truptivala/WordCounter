package com.src;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Trupti Vala
 *
 */
public class WordCounter {

	public static final String BASEPATH = "C:/temp/"; 
	
	
	/**
	 * Method that counts number of words in given string.
	 * @param String s - a line from the file
	 * @return int count - number of words in given string s
	 * @throws 
	 */
	
	public static int wordCounter(String s) {
		int count = 0;
		boolean preCharWasLetterOrDigit = false, isLetterOrDigit = false;
		int len = s.length() - 1;
		
		
		int i = 0;
		while (i < s.length()) {
			isLetterOrDigit = Character.isLetterOrDigit(s.charAt(i));
			
			if (isLetterOrDigit) {
				if (i == len) {
					count++;
				} else {
					preCharWasLetterOrDigit = true;
				}

			} else if (preCharWasLetterOrDigit) {
				count++;
				preCharWasLetterOrDigit = false;
			}
			i++;
		}
		return count;
	}

	/**
	 * 
	 * @param String fileName - name of the file
	 * @return String - file content after reading a file
	 * @throws IOException
	 */
	public static String readFile(String name) throws IOException {
		if(!name.endsWith(".txt"))
			throw new IOException("File format is not supported");
		
		BufferedReader br = new BufferedReader(new FileReader(name));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line.trim().replace("'", ""));
				sb.append(" ");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	/**
	 * 
	 * @param String fileName - name of the file
	 * @return int word count
	 * @throws IOException
	 * @throws Exception
	 */
	public static int wordCountHelper(String fileName) throws IOException, Exception {
		return wordCounter(readFile(BASEPATH + fileName));
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		
		JFileChooser chooser= new JFileChooser();

		int choice = chooser.showOpenDialog(chooser);

		if (choice != JFileChooser.APPROVE_OPTION) return;

		File chosenFile = chooser.getSelectedFile();
		
		String fileName = chosenFile.getAbsolutePath();

		String content = readFile(fileName);
		
		System.out.println("Word count: "+wordCounter(content));
	}

}
