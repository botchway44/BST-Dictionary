

import java.util.Iterator;

import edu.iup.cosc310.util.BSTDictionary;

public class TestLs {

	public static void main(String[] args) {

		BSTDictionary<String,Integer> dictionary = new BSTDictionary<String,Integer>();
		
		System.out.println(dictionary.put("C", 2));
//		System.out.println("After Insert Key => " + dictionary.key);
		
		System.out.println(dictionary.put("A", 4));
//		System.out.println("After Insert Key => " + dictionary.key);
		
		System.out.println(dictionary.put("B", 6));
//		System.out.println("After Insert Key => " + dictionary.key);
//		System.out.println("After Insert left => " + dictionary.left.key);
//		System.out.println("After Insert right => " + dictionary.right.key);
		
		System.out.println(dictionary.put("F", 5));
//		System.out.println("After Insert Key => " + dictionary.key);

//		System.out.println(" dict value " + dictionary.value);
		System.out.println(" num of keys " + dictionary.noKeys());
		
		
//		dictionary.listAllKeys(dictionary);
		
		System.out.println(" Value of " + dictionary.get("D"));
		
		
		System.out.println(" Removing " + dictionary.remove("C"));
//	
//		dictionary.listAllKeys(dictionary);
//		System.out.println(" dict value " + dictionary.value);
		
		System.out.println(" Removing " + dictionary.remove("A"));
	//	
//			dictionary.listAllKeys(dictionary);
//			System.out.println(" dict value " + dictionary.value);
//		System.out.println(dictionary.keys().hasNext());
//
//		System.out.println(dictionary.keys().next());
			System.out.println(dictionary.put("B", 6));
			
			Iterator<String> iter = dictionary.keys();
//			

			while(iter.hasNext()) {

				System.out.println(" Next " + iter.next());
			}
	}
}
