/* Cracking the Code Interview 1.9 StringRotation
 * Check is str2 is a rotation of str1 in 1 isSubstring()
 */

import java.util.Arrays;

public class StringRotation {
    public static void main(String[] args) {
        if (args.length > 1) {
            print("stringRotation() " + args[0] + ", " + args[1] + " : " +
                stringRotation(args[0], args[1]));
        } else {
            print("stringRotation() waterbottle, erbottlewat : " +
                stringRotation("waterbottle", "erbottlewat"));
        }
    }

    public static void print(Object arg) {
        System.out.println(arg); 
    }

    public static boolean isSubstring(String str1, String str2) {
        return str1.indexOf(str2) != -1;
    }

    public static boolean stringRotation(String str1, String str2) {
        int len = str1.length() * (str1.length() + 1);
        StringBuilder allRotations = new StringBuilder(len);
        // Collect all the space-separated rotations of str1 via strinbuilder
        for (int i = 0; i < str1.length(); i++) {
            allRotations.append(str1.substring(i, str1.length()))
                        .append(str1.substring(0, i))
                        .append(" ");
        }
        String all = allRotations.toString();
        // To call substring on the set just once
        return str1.length() == str2.length() && isSubstring(all, str2);
    }
}
