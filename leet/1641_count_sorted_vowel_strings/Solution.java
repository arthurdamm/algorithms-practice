// LeetCode 1641. Count Sorted Vowel Strings
// https://leetcode.com/problems/count-sorted-vowel-strings/
// O(nk) time-and-space
class Solution {
    int[][] memo;
    
    public int countVowelStrings(int n) {
        memo = new int[n + 1][6];
        Arrays.fill(memo[0], 1);
        return dp(n, 5);
    }
    
    int dp(int i, int vowel) {
        if (vowel == 0)
            return 0;
        if (memo[i][vowel] == 0)
            memo[i][vowel] = dp(i, vowel - 1) + dp(i - 1, vowel);
        return memo[i][vowel];
    }
}

class SolutionBottomUp {  
    public int countVowelStrings(int n) {
        int dp[][] = new int[n][6], ret = 0;
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;
        for (int i = 1; i < n; i++)
            for (int vowel = 1; vowel < 6; vowel++)
                dp[i][vowel] = dp[i][vowel - 1] + dp[i - 1][vowel];
        for (int k : dp[n - 1])
            ret += k;
        return ret;
    }
}
