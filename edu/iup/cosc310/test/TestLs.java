package edu.iup.cosc310.test;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import edu.iup.cosc310.util.HashtableDictionary;

public class TestLs {

	public static void main(String[] args) {

		HashtableDictionary<String,Set<Integer>> dictionary = new HashtableDictionary<>();
//		System.out.println("gun".hashCode() % 100);
		
		TreeSet<Integer> pages = new TreeSet<Integer>();
		pages.add(2);
		pages.add(1);
		
		System.out.println(dictionary.put("C", pages));
		
		TreeSet<Integer> pages2 = new TreeSet<Integer>();
		pages2.add(23);
		pages2.add(11);
		

		
		System.out.println(dictionary.put("Fortune", pages2));
		
		
//		dictionary.remove("C");

		TreeSet<Integer> tempC = (TreeSet<Integer>) dictionary.get("C");
		tempC.add(4);
		tempC.add(7);

		System.out.println(dictionary.put("Candles", tempC));
//		System.out.println(tempC.toString());
		
		System.out.println(dictionary.noKeys());
		TreeSet<Integer> temp = (TreeSet<Integer>) dictionary.get("Fortune");
		System.out.println("Fortune"+temp.toString());
		
		TreeSet<Integer> t = (TreeSet<Integer>) dictionary.get("C");
		System.out.println(t.toString());
		
		TreeSet<Integer> tC = (TreeSet<Integer>) dictionary.get("C");
		tC.add(9);
		tC.add(0);

		System.out.println(dictionary.put("Grass", tC));
		
//		System.out.println(dictionary.put("Live", 1));
//		System.out.println("After Insert Key => " + dictionary.key);
		
//		System.out.println(dictionary.put("A", 4));
//		System.out.println("After Insert Key => " + dictionary.key);
		
//		System.out.println(dictionary.put("B", 6));
//		System.out.println("After Insert Key => " + dictionary.key);
//		System.out.println("After Insert left => " + dictionary.left.key);
//		System.out.println("After Insert right => " + dictionary.right.key);
		
//		System.out.println(dictionary.put("F", 5));
//		System.out.println("After Insert Key => " + dictionary.key);

//		System.out.println(" dict value " + dictionary.value);
//		System.out.println(" num of keys " + dictionary.noKeys());
		
		
//		dictionary.listAllKeys(dictionary);
		
//		System.out.println(" Value of " + dictionary.get("D"));
		
		
//		System.out.println(" Removing " + dictionary.remove("C"));
//	
//		dictionary.listAllKeys(dictionary);
//		System.out.println(" dict value " + dictionary.value);
		
//		System.out.println(" Removing " + dictionary.remove("A"));
	//	
//			dictionary.listAllKeys(dictionary);
//			System.out.println(" dict value " + dictionary.value);
//		System.out.println(dictionary.keys().hasNext());
//
//		System.out.println(dictionary.keys().next());
//			System.out.println(dictionary.put("B", 6));
			
			Iterator<String> iter = dictionary.keys();
//			

			while(iter.hasNext()) {
				System.out.println(" Next " + iter.next());
			}
	}
}
