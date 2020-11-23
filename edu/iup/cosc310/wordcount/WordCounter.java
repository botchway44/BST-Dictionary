package edu.iup.cosc310.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import edu.iup.cosc310.util.BSTDictionary;

/**
 * Word Counter Program that uses the BSTDictionary to find unique words in a
 * program and their number of occurrence
 * 
 * @author Amma Darkwah
 *
 */
public class WordCounter {

	private static BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();

	/**
	 * Program Entry Point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		loadFile();
		Iterator<String> iter = dictionary.keys();

		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(" Key = " + key + " \t value = " + dictionary.get(key));
		}
	}

	/**
	 * Load all words from the File
	 */
	private static void loadFile() {
		try {
			Scanner scan = new Scanner(new File("COSC 310 Syllabus.txt"));
			while (scan.hasNextLine()) {
				String[] line = scan.nextLine().split("\\W+");

				unpackList(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unpack a list of words and put them into the dictionary
	 * 
	 * @param list
	 */
	private static void unpackList(String[] list) {
		int len = list.length;

		for (int i = 0; i < len; i++) {
			if (dictionary.get(list[i].toLowerCase()) == null) {
				dictionary.put(list[i].toLowerCase(), 1);
			} else {
				int val = dictionary.get(list[i].toLowerCase());
				dictionary.put(list[i].toLowerCase(), val + 1);
			}
		}
	}
}
