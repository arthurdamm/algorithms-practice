class Solution {
    public static int[] KMPTable(String s) {
        int[] kmp = new int[s.length()];
        for (int i = 1, t = 0; i < s.length(); i++) {
            t = kmp[i - 1];
            while (t > 0 && s.charAt(i) != s.charAt(t))
                t = kmp[t - 1];
            if (s.charAt(t) == s.charAt(i))
                t += 1;
            kmp[i] = t;
        }
        return kmp;
    }
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2)
            return false;
        int[] kmp = KMPTable(s);
        int n = s.length();
        return kmp[n - 1] > 0 && n % (n - kmp[n - 1]) == 0;
    }
}

public class KMP {
    public static void main(String args[])
    {
        System.out.println(new Solution().repeatedSubstringPattern(args[0]));
    }
}
