package recursive;

public class FindShortestSubString {
	import java.io.*;
	import java.util.*;

	class Solution {
	  // [ab]
	 // asbcdaba -"a" ,...
	  //"asb","bcda", "ab", "ba"
	  //s=0, end=0 map<Character, Count>, count (should be equal to arr.length)
	  //a
	  
	  //abc -> a, ab, abc, b, bc,c abc.substring(0,3) = abc
	  static String getShortestUniqueSubstring(char[] arr, String str) {
	     List<String> allCandidates = new ArrayList<>();
	     for (int i = 0 ; i < str.length() ; i ++){
	        for (int j=i + 1 ; j <str.length() ; j ++){
	          String result = str.substring(i, j);
	          if (result.length() >= arr.length && isValidSubString(str, arr)){
	              allCandidates.add(result);
	          }          
	       }
	     }
	      System.out.println(allCandidates);
	    
	    int min = Integer.MAX_VALUE;
	    String result = "";
	    for (String s: allCandidates){
	      if (min > s.length()){
	        min = s.length();
	        result = s;
	      }
	    }
	    return result;
	  }
	  
	  static boolean isValidSubString(String subString, char[] arr){
	      for (int i= 0 ; i < arr.length ; i ++){
	        if (!subString.contains(""+arr[i] )){
	          return false;
	        }
	      }
	       return true;
	  }

	  public static void main(String[] args) {
	    String s = "asbcdaba";
	    char[] arr = {'a', 'b'};
	    String result = getShortestUniqueSubstring(arr, s);
	    System.out.println(result);
	  }

	}
	
	  // [ab]
	 // asbcdaba -"a" ,...
	  //"asb","bcda", "ab", "ba"
	  //s=0, end=0 map<Character, Count>, count (should be equal to arr.length)
	  //asb , count=2 , min=3
	  //s=1, end=2, sb , count--
	  //bcda
	  //ab
}
