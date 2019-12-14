/* Cracking the Code Interview 1.5 oneAway
 * checks if str1 is one change (insert/replace/remove operation)
 * away/different from str2
 */

import java.util.*;

public class OneAway {
    public static void main(String[] args) {
        if (args.length >= 2)
            print("oneAway() " + args[0] + ", " + args[1] + " : " +
                oneAway(args[0].toCharArray(), 0, args[1].toCharArray(), 0));
        else
            print("oneAway() pale, sale : " +
                oneAway("pale".toCharArray(), 0, "sale".toCharArray(), 0));
    }

    public static void print(Object arg) {
        System.out.println(arg); 
    }

    public static boolean oneAway(char[] str1, int i, char[] str2, int j) {
        return nAway(str1, i, str2, j, 1);
    }

    public static boolean nAway(char[] str1, int i, char[] str2, int j, int dist) {
        for (; i < str1.length && j < str2.length; i++, j++) {
            if (str1[i] == str2[j])
                continue;
            if (dist > 0)
                return nAway(str1, i + 1, str2, j, dist - 1) ||
                       nAway(str1, i, str2, j + 1, dist - 1) ||
                       nAway(str1, i + 1, str2, j + 1, dist - 1);
            return false;
        }
        return str1.length - i <= dist && str2.length - j <= dist;
    }
}
