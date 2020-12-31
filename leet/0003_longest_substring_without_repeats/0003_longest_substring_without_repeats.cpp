// LeetCode 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// O(n) time, O(n) space
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> seen;
        int _max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (seen.find(s[j]) != seen.end())
                i = max(i,seen[s[j]] + 1);
            _max = max(_max, j - i + 1);
            seen[s[j]] = j;
        }
        return _max;            
    }
};
