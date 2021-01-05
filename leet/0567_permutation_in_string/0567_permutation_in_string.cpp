// LeetCode 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/
// O(n + m) time, O(1) space
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int c1[127] = {0}, c2[127] = {0};
        int sum1 = 0, sum2 = 0;
        for (auto c : s1) {
            c1[c]++;
            sum1++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (c1[s2[i]] > 0)
                if (c2[s2[i]]++ < c1[s2[i]])
                    sum2++;
            if (i >= s1.length())
                if (c1[s2[i - s1.length()]] > 0)
                    if (--c2[s2[i - s1.length()]] < c1[s2[i - s1.length()]])
                        sum2--;
            if (sum2 == sum1)
                break;
        }
        return sum2 == sum1;
    }
};

// O(n + m) time, O(1) space
class SolutionMap {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> c1, c2;
        int sum1 = 0, sum2 = 0;
        for (auto c : s1) {
            c1[c]++;
            sum1++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (c1[s2[i]] > 0)
                if (c2[s2[i]]++ < c1[s2[i]])
                    sum2++;
            if (i >= s1.length())
                if (c1[s2[i - s1.length()]] > 0)
                    if (--c2[s2[i - s1.length()]] < c1[s2[i - s1.length()]])
                        sum2--;
            if (sum2 == sum1)
                break;
        }
        return sum2 == sum1;
    }
};
