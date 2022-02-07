// LeetCode 389. Find the Difference
// O(n) time, O(1) space
class Solution {
    public char findTheDifference(String s, String t) {
        char charBits = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            charBits ^= s.charAt(i);
            charBits ^= t.charAt(i);
        }
        return charBits;
    }
}
