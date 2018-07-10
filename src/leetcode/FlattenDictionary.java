package leetcode;

import java.io.*;
import java.util.*;

class FlattenDictionary {
	
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    HashMap <String, String> flatDict = new HashMap<String, String>();
    flattenDictionaryHelper("", dict, flatDict);
    return flatDict;
  }
  
  private static void flattenDictionaryHelper(String initialKey, HashMap<String, Object> dict, HashMap<String, String> flatDict){
    for (String key : dict.keySet()){
      Object value = dict.get(key);
      
      if (value instanceof String || value instanceof Integer){ // The value is a String tpe
          if (initialKey == null || initialKey.equals("") ){
              flatDict.put(key, String.valueOf(value));
          }
          else{
            if (!key.equals(""))
              flatDict.put(initialKey + "." + key, (String)value);
            else
              flatDict.put(initialKey, (String)value);
          }
      }
      else { // recursive loop to get inner dict
         if (initialKey == null || initialKey.equals("")){
            flattenDictionaryHelper(key, ((HashMap<String, Object>) value), flatDict);
         }
         else
         {
           flattenDictionaryHelper(initialKey + "." + key, ((HashMap<String, Object>) value), flatDict);
         }        
      }
    }
  }

  public static void main(String[] args) {

  }

  /***
   * 
Input: {"Key1":"1","Key2":{"a":"2","b":"3","c":{"d":"3","e":"1"}}},Expected: {"Key1":"1","Key2.a":"2","Key2.b":"3","Key2.c.d":"3","Key2.c.e":"1"},Actual: {Key2.c.d=3, Key2.c.e=1, Key1=1, Key2.a=2, Key2.b=3}
Test Case #2
Input: {"Key":{"a":"2","b":"3"}},Expected: {"Key.a":"2","Key.b":"3"},Actual: {Key.a=2, Key.b=3}
Test Case #3
Input: {"Key1":"1","Key2":{"a":"2","b":"3","c":{"d":"3","e":{"f":"4"}}}},Expected: {"Key1":"1","Key2.a":"2","Key2.b":"3","Key2.c.d":"3","Key2.c.e.f":"4"},Actual: {Key2.c.d=3, Key1=1, Key2.a=2, Key2.b=3, Key2.c.e.f=4}
Test Case #4
Input: {"":{"a":"1"},"b":"3"},Expected: {"a":"1","b":"3"},Actual: {a=1, b=3}
Test Case #5
Input: {"a":{"b":{"c":{"d":{"e":{"f":{"":"pramp"}}}}}}},Expected: {"a.b.c.d.e.f":"pramp"},Actual: {a.b.c.d.e.f=pramp}
Test Case #6
Input: {"a":"1"},Expected: {"a":"1"},Actual: {a=1}
   * 
   * 
   */
}