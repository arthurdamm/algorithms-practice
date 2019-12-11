/* Cracking the Code Interview 1.4
 * checks if string is permutation of a palindrome
 */

import java.util.*;

public class paliPermutation {
  public static void main(String[] args) {
    print("paliPermutation(Tact Coa): " + paliPermutation("Tact Coa"));
    print("paliPermutation(" + args[0] + "): " + paliPermutation(args[0]));
  }

  public static void print(Object arg) {
    System.out.println(arg); 
  }

  public static boolean paliPermutation(String arg) {
    int[] letters = new int[26];
    for (char c : arg.toCharArray()) {
        if (c == ' ') continue;
        if (c >= 97) letters[c - 97]++;
        else letters[c - 65]++;
    }
    int odds = 0;
    for (int e : letters) odds += e % 2;
    return odds <= 1;
  }
}
