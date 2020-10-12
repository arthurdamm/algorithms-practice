// LeetCode 859. Buddy Strings
// O(n) time, O(1) space
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        int a = -1, b = -1;
        boolean seen[] = new boolean[26], doubleChar = false;
        for (int i = 0; i < A.length(); i++) {
            if (seen[A.charAt(i) - 'a'])
                doubleChar = true;
            else
                seen[A.charAt(i) - 'a'] = true;
            if (A.charAt(i) != B.charAt(i)) {
                if (a != -1) {
                    if (b != -1)
                        return false;
                    b = i;
                } else
                    a = i;
            }
        }
        if (a != -1) {
            return b != -1 &&
                A.charAt(b) == B.charAt(a) && A.charAt(a) == B.charAt(b);
        } else
            return doubleChar;
    }
}
