/* Cracking the Code Interview 1.1
 * checks if string has all unique characters
 */

import java.util.*;

public class IsUnique {
  public static void main(String[] args) {
    print("isUnqiue: " + isUniqueString(args[0]));
    print("isUniqueStringNoDatastructure: " + isUniqueStringNoDatastructure(args[0]));
  }

  public static void print(Object arg) {
    System.out.println(arg); 
  }

  public static boolean isUniqueString(String arg) {
    char[] str = arg.toCharArray();
    HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
    boolean ret = true;

    for (char c : str) {
      Integer found = letters.get(c);
      if (found != null)
      {
        letters.put(c, ++found);
        print(c + " found: " + found);
        ret = false;
      } else
        letters.put(c, 1);
    }
    return ret;
  }

  public static boolean isUniqueStringNoDatastructure(String arg) {
    char[] str = arg.toCharArray();
    Arrays.sort(str);
    boolean ret = true;

    for (int i = 0; i < str.length - 1; i++) {
      if (str[i] == str[i + 1]) {
        print(str[i] + " found");
        ret = false;
      }
    }
    return ret;
  }
}
