/* Cracking the Code Interview 1.3
 * checks if str1 is a permutation of str2
 */

import java.util.*;

public class urlify {
    public static void main(String[] args) {
        System.out.println("example: [" + urlifyBrute("Mr John Smith    ", 13) + "]");
        System.out.println("example: [" + urlifyBrute("Mr John Sm i th        ", 15) + "]");
    }

    public static void print(Object arg) {
        System.out.println(arg); 
    }

    static String urlifyBrute(String arg, int len) {
        char[] str = arg.toCharArray();
        int spaces = 0;
        // Count the number of spaces in first pass.
        for (int i = 0; i < len; i++)
            if (str[i] == ' ') spaces++;
        // Now start from the back, shifting everything by spaces * 2
        for (int i = len - 1, shift = spaces * 2; i >= 0; i--) {
            print("Char:" + str[i]);
            // every time we hit a space...
            if (str[i] == ' ') {
                // replace chars (there is enough space made behind us)
                str[i + shift - 2] = '%';
                str[i + shift - 1] = '2';
                str[i + shift] = '0';
                // reduce shifting
                shift -= 2;
            }
            else // just shift
                str[i + shift] = str[i];
            print(Arrays.toString(str));
        }
        return new String(str);
    }
}
