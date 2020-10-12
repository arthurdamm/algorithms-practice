// LeetCode 316. Remove Duplicate Letters
// O(n) time-and-space
class Solution {
    public String removeDuplicateLetters(String s) {
        int lastIndex[] = new int[26], uniqueLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (lastIndex[s.charAt(i) - 'a'] == 0)
                uniqueLen++;
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        if (lastIndex[s.charAt(0) - 'a'] != 0)
            uniqueLen--;
        
        char str[] = new char[uniqueLen];
        int j = -1;
        boolean used[] = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (used[s.charAt(i) - 'a'])
                continue;
            while (j > -1 && str[j] > s.charAt(i) && lastIndex[str[j] - 'a'] > i)
                used[str[j--] - 'a'] = false;
            str[++j] = s.charAt(i);
            used[s.charAt(i) - 'a'] = true;
        }
        return new String(str);
    }
}

