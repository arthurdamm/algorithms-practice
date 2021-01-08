// LeetCode 1662. Check If Two String Arrays are Equivalent
// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
// O(min(n, m)) time, O(1) space
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2))
                return false;
            if (++j1 == word1[i1].length()) {
                i1++;
                j1 = 0;
            }
            if (++j2 == word2[i2].length()) {
                i2++;
                j2 = 0;
            }
        }
        if (i1 != word1.length || i2 != word2.length)
            return false;
        return true;
    }
}
