// LeetCode 1657. Determine if Two Strings Are Close
// https://leetcode.com/problems/determine-if-two-strings-are-close/
// O(n) time, O(1) space
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        char s1[] = word1.toCharArray(), s2[] = word2.toCharArray();
        int count1[] = new int[26], count2[] = new int[26];
        for (int i = 0; i < s1.length; i++) {
            count1[s1[i] - 'a']++;
            count2[s2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++)
            if ((count1[i] == 0) != (count2[i] == 0))
                return false;
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
