package problems;

import java.util.Scanner;


public class ReverseString {
	// iteration method
	public static String reverseString(String input) {
    	// Handle null and empty
    	if (input != null && !input.isEmpty()) {
    		// make a copy of original string
        	char[] output = input.toCharArray();
        	int left = 0;
        	int right = output.length - 1;
        	
        	while (left != right) {
        		char temp = output[left];
        		output[left] = output[right];
        		output[right] = temp;
        		left ++;
        		right --;
        	}
        	
        	// Complexity O(n)
            return String.valueOf(output);
    	} else {
    		return "";
    	}
    	
    }
    
    // recursive method
    public static String reverseStringRecursive(String input) {
    	if (input.length() < 2) {
    		return input;
    	}
    	return reverseStringRecursive(input.substring(1)) + input.charAt(0);
    }
    
    // use string builder
    
    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        System.out.println(reverseStringRecursive(a));
    }
}