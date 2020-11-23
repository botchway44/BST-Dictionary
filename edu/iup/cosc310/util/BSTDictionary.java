package edu.iup.cosc310.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Binary Search Tree Dictionary Implementation
 * 
 * @author Amma Darkwah
 *
 * @param <K> Data type for the keys
 * @param <V> Data type for the values
 */
public class BSTDictionary<K, V> implements Dictionary<K, V> {

	private K key = null;
	private V value = null;

	private int numKeys = 0;
	private BSTDictionary<K, V> left = null;
	private BSTDictionary<K, V> right = null;

	/**
	 * Put a key together with its associated value into the dictionary. If the key
	 * already exists then the new value replaces the current value associated with
	 * the key. Values can be retrieved using the get method.
	 * 
	 * @param key   the key
	 * @param value the new value
	 * @return the original value if the key already exists in the dictionary,
	 *         otherwise null.
	 */
	@Override
	public V put(K key, V value) {

		BSTDictionary<K, V> node = insert(this, key);

		node.key = key;
		node.value = value;
		this.numKeys++;

		return node.value;
	}

	/***
	 * A Recursive method that finds the next available slot for insertion
	 * 
	 * @param current
	 * @param newKey
	 * @param newValue
	 * 
	 * @return BSTDictionary<K,V>
	 */
	private BSTDictionary<K, V> insert(BSTDictionary<K, V> current, K newKey) {

		if (!current.isEmpty()) {

			// compare the left and right nodes
			int res = ((Comparable) newKey).compareTo(current.key);

			if (res == 0) {
				return current;
			} else if (res < 0) {
				if (current.left == null)
					current.left = new BSTDictionary<K, V>();
				return this.insert(current.left, newKey);
			} else {

				if (current.right == null)
					current.right = new BSTDictionary<K, V>();
				return this.insert(current.right, newKey);
			}
		}

		return current;
	}

	/**
	 * Get the current value associated with a given key.
	 * 
	 * @param key the key
	 * @return the current value associated with the key in the dictionary if found,
	 *         otherwise null.
	 */
	@Override
	public V get(K key) {
		BSTDictionary<K, V> node = getNode(this, key);

		if (node == null)
			return null;

		return node.value;
	}

	/***
	 * Using the Current Node, it looks for a a specific node with a specified Key
	 * 
	 * @param current
	 * @param newKey
	 * @return BSTDictionary<K,V>
	 */
	private BSTDictionary<K, V> getNode(BSTDictionary<K, V> current, K newKey) {
		if (!current.isEmpty()) {

			// compare the left and right nodes
			int res = ((Comparable) newKey).compareTo(current.key);

			if (res == 0) {
				return current;

			} else if (res < 0 && current.left != null) {

				return this.getNode(current.left, newKey);
			} else if (current.right != null) {

				return this.getNode(current.right, newKey);
			}
		}

		return null;
	}

	/**
	 * Remove the key and its associated value associated from the dictionary. The
	 * value associated with the key is returned. If the key does not exist in the
	 * dictionary then null is returned.
	 * 
	 * @param key the key
	 * @return the value associated with the removed key in the dictionary. If the
	 *         key did not exist then null.
	 */
	@Override
	public V remove(K key) {

		BSTDictionary<K, V> currentNode = getNode(this, key);
		if (currentNode == null)
			throw new NoSuchElementException();

		BSTDictionary<K, V> leftMostNode = getLeftMostChildNode(currentNode);

		V copy = currentNode.value;

		currentNode.value = leftMostNode.value;
		currentNode.key = leftMostNode.key;

		leftMostNode.key = null;
		leftMostNode.value = null;

		this.numKeys--;

		return copy;
	}

	/**
	 * Finds the Leftmost Child given a parent node
	 * 
	 * @param current
	 * @return BSTDictionary<K,V>
	 */
	private BSTDictionary<K, V> getLeftMostChildNode(BSTDictionary<K, V> current) {

		// check if its a child node
		if (current.left == null && current.right == null)
			return current;

		if (current.left != null)
			return getLeftMostChildNode(current.left);

		return getLeftMostChildNode(current.right);
	}

	/**
	 * An Iterator Class For the BSTDictionary Class
	 * 
	 * @author Amma Darkwah
	 *
	 * @param <K>
	 * @param <V>
	 */
	class DictionaryIterator<K, V> implements Iterator<K> {

		private Object[] keys;
		private int count = 0;

		public DictionaryIterator(BSTDictionary<K, V> dictionary, int numOfKeys) {

			this.keys = new Object[numOfKeys];
			this.getAllKeys(dictionary);
			this.count = 0;

		}

		/**
		 * Checks if the iterator has a next value
		 * 
		 * @return boolean
		 */
		@Override
		public boolean hasNext() {

			if (count < keys.length && keys[count] != null)
				return true;
			return false;
		}

		/**
		 * Returns the Next Key
		 * 
		 * @return K
		 */
		@Override
		public K next() {

			return (K) this.keys[count++];
		}

		/**
		 * Gets all the keys into a List for the iterator
		 * 
		 * @param current
		 */
		public void getAllKeys(BSTDictionary<K, V> current) {
			if (current != null && current.key != null) {

				getAllKeys(current.left);

				if (current.key != null)
					this.keys[count++] = current.key;

				getAllKeys(current.right);
			}
		}
	}

	/**
	 * Create an Iterator to iterate over the keys of the dictionary.
	 * 
	 * @return an Iterator to iterator over the keys.
	 */
	@Override
	public Iterator<K> keys() {

		return new DictionaryIterator<K, V>(this, this.numKeys);
	}

	/**
	 * Test if the dictionary is empty
	 * 
	 * @return true if the dictionary is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {

		return this.key == null;
	}

	/**
	 * Get the number of keys in the dictionary
	 * 
	 * @return the number of keys in the dictionary
	 */
	@Override
	public int noKeys() {
		return this.numKeys;
	}

}
