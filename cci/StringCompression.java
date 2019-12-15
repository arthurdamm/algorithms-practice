/* Cracking the Code Interview 1.6 StringCompression
 * Compresses string aabcccccaaa to a2b1c5a3
 * or does nothing if compressed string not shorter
 */

public class StringCompression {
    public static void main(String[] args) {
        if (args.length > 0)
            print("StringCompression() " + args[0] + " : " + stringCompression(args[0]));
        else
            print("StringCompression() aabcccccaaa : " + stringCompression("aabcccccaaa"));
    }

    public static void print(Object arg) {
        System.out.println(arg); 
    }

    public static String stringCompression(String arg) {
        char[] str = arg.toCharArray();
        char curr = str[0];
        int count = 1;
        int total = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == curr) {
                count++;
            }
            else {
                total += ((int)Math.log10(count)) + 2;
                curr = str[i];
                count = 1;
            }
        }
        total += ((int)Math.log10(count)) + 2;
        if (total >= str.length)
            return arg;

        curr = str[0];
        count = 1;
        StringBuilder ret = new StringBuilder(total);
        for (int i = 1; i < str.length; i++) {
            if (str[i] == curr) {
                count++;
            }
            else {
                ret.append(curr).append(count);
                curr = str[i];
                count = 1;
            }
        }
        ret.append(curr).append(count);
        return ret.toString();
    }

}
