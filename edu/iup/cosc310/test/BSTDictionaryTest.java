package edu.iup.cosc310.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import edu.iup.cosc310.util.BSTDictionary;

public class BSTDictionaryTest {

	@Test
	void testInitial() {
		BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();
		assertEquals(true, dictionary.isEmpty());
		assertEquals(2, dictionary.put("C", 2));
		assertEquals(false, dictionary.isEmpty());

	}

	/**
	 * Test inserting keys
	 */
	@Test
	void put() {
		BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();

		assertEquals(2, dictionary.put("C", 2));
		assertEquals(4, dictionary.put("A", 4));
		assertEquals(6, dictionary.put("B", 6));

	}

	/**
	 * Test getting keys
	 */
	@Test
	void get() {
		BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();

		assertEquals(2, dictionary.put("C", 2));
		assertEquals(4, dictionary.put("A", 4));
		assertEquals(6, dictionary.put("B", 6));

		assertEquals(2, dictionary.get("C"));
		assertEquals(4, dictionary.get("A"));
		assertEquals(null, dictionary.get("F"));
	}

	/**
	 * Test Number of Keys
	 */
	@Test
	void noKeys() {
		BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();

		assertEquals(2, dictionary.put("C", 2));
		assertEquals(4, dictionary.put("A", 4));
		assertEquals(6, dictionary.put("B", 6));

		assertEquals(3, dictionary.noKeys());

		assertEquals(2, dictionary.remove("C"));
		assertEquals(4, dictionary.remove("A"));

		assertEquals(1, dictionary.noKeys());
	}

	/**
	 * Test Iterator
	 */
	@Test
	void testIterator() {
		BSTDictionary<String, Integer> dictionary = new BSTDictionary<String, Integer>();

		Iterator<String> iter = dictionary.keys();

		assertEquals(false, iter.hasNext());

		assertEquals(2, dictionary.put("C", 2));
		assertEquals(4, dictionary.put("A", 4));
		assertEquals(6, dictionary.put("B", 6));

		Iterator<String> iter2 = dictionary.keys();
		assertEquals(true, iter2.hasNext());

		iter2.next();
		iter2.next();
		iter2.next();

		assertEquals(false, iter2.hasNext());
	}
}
