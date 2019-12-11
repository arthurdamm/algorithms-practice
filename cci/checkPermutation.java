/* Cracking the Code Interview 1.1
 * checks if str1 is a permutation of str2
 */

import java.util.*;

public class checkPermutation {
    public static void main(String[] args) {
        System.out.println("checkPermutationSort: " + checkPermutationSort(args[0], args[1]));
        System.out.println("checkPermutationHash: " + checkPermutationHash(args[0], args[1]));
    }

    public static boolean checkPermutationSort(String _str1, String _str2) {
        char[] arr1 = _str1.toCharArray(), arr2 = _str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String str1 = new String(arr1);
        String str2 = new String(arr2);
        System.out.println(str1 + ":" + str2);
        return str1.equals(str2);        
    }

    public static boolean checkPermutationHash(String _str1, String _str2) {
        char[] arr1 = _str1.toCharArray(), arr2 = _str2.toCharArray();
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        int len = 0;
        for (Character c : arr1) {
            len++;
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        for (Character c : arr2) {
            int n = chars.getOrDefault(c, 0);
            if (n <= 0) return false;
            chars.put(c, n - 1);
            len--;
        }

        return len == 0;
    }
}
