// LeetCode 131. Palindrome Partitioning
// https://leetcode.com/problems/palindrome-partitioning/
// O(n*2^n) time-and-space, bottom-up DP + backtracking
class Solution {
public:
    vector<vector<string>> dp;
    vector<vector<string>> partitions;
    
    vector<vector<string>> partition(string s) {
        makeDP(s);
        vector<string> partition;
        dfs(s, 0, partition);
        return partitions;
    }
    
    private: void makeDP(string &s) {
        dp.resize(s.size());
        for (size_t i = 0; i < s.length(); i++) {
            for (size_t j = i; j < s.length(); j++) {
                if (isPali(s, i, j + 1))
                    dp[i].push_back(s.substr(i, j - i + 1));
            }
        }
    }
    
    private: bool isPali(string &s, size_t i, size_t j) {
        while (i < j)
            if (s[i++] != s[--j])
                return false;
        return true;
    }
    
    private: void dfs(string &s, size_t i, vector<string> &partition) {
        if (i == s.size()) {
            partitions.push_back(partition);
            return;
        }
        for (auto pali : dp[i]) {
            partition.push_back(pali);
            dfs(s, i + pali.size(), partition);
            partition.pop_back();
        }
    }
};
