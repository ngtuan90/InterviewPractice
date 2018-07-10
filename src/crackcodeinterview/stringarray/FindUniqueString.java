package crackcodeinterview.stringarray;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/***
 * Problem 1.1: Determine if a string contain unique characters. With or without using data structure
 * @author eedwngu
 *
 */
public class FindUniqueString {

	public static void main(String args[]) {
		// Can string belong to ASSII or unicode  ? (256 bit or 128 bit) (case sensitive?) // null empty ?
		String s1 = "aklbviueoryt" ; // shoud return true
		String s2 = "iyjcbdmvfi" ; // dup last char, should return false
		String s3 = "a";		// 1 character string shoud return true
		String s4 = "";			// empty or null should return false or exception ?
				
		System.out.println(isStringUnique3(s1)); // true
		System.out.println(isStringUnique3(s2)); // false
		System.out.println(isStringUnique3(s3)); // true
		System.out.println(isStringUnique3(s4)); // false
	}
	
	/***
	 * Method to determine if string contain unique characters
	 * @param input string need to check
	 * @return true if unique, false if not
	 */
	public static boolean isStringUnique (String input) {		
		// Implementation using Set . Time Complexity O(n)
		// Check null
		if(input == null || input.isEmpty())
			return false;
		else {
			// assume this is ascii and only have maximum 128 unique value 
			// so if it over 128 mean false
			if (input.length() > 128)
				return false;
			else {
				Set uniqueString = new HashSet();
				for (int i = 0; i < input.length() ; i ++) {
					if (uniqueString.contains(input.charAt(i)))
						return false;
					else
						uniqueString.add(input.charAt(i));
				}	
				return true;
			}			
		}		
	}
	
	/***
	 * Method to determine if string contain unique characters do not using any data structure
	 * @param input string need to check
	 * @return true if unique, false if not
	 */
	public static boolean isStringUnique2(String input) {		
		// Implementation using Set . Time Complexity O(n)
		// Check null
		if(input == null || input.isEmpty())
			return false;
		else {
			// assume this is ascii and only have maximum 128 unique value 
			// so if it over 128 mean false
			if (input.length() > 128)
				return false;
			else {
				boolean [] placeHolder = new boolean[128];
				for (int i = 0; i < input.length() ; i ++) {
					int value = input.charAt(i);
					if (placeHolder[value])
						return false;					
					placeHolder[value] = true; // this char character already hold in
				}	
				return true;
			}			
		}		
	
	}
	
	// Using Hashtable
	public static boolean isStringUnique3(String input) {
		if(input == null || input.isEmpty())
			return false;
		else {
			Map<Character, Boolean> table = new Hashtable<Character, Boolean>();
			for (int i = 0; i < input.length() ; i ++) {
				char key = input.charAt(i);
				if (table.get(key) == null) {
					table.put(key, true);
				}else {
					return false;
				}		

			}
			return true;
		}	
	}
}
