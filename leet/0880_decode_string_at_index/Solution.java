// LeetCode 880. Decoded String at Index
// O(n) time, O(1) space
class Solution {
    public String decodeAtIndex(String S, int K) {
        long n = 0;
        int i = 0;
        for (i = 0; i < S.length(); i++)
            if (Character.isDigit(S.charAt(i)))
                n *= (S.charAt(i) - '0');
            else
                n++;
        while (i-- >= 0) {
            if (Character.isDigit(S.charAt(i))) {
                n /= (S.charAt(i) - '0');
                K %= n;
            } else if (K % n-- == 0)
                return S.substring(i, i + 1);
        }
        return "";
    }
}
