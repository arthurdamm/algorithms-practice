// LeetCode 91. Decode Ways
// https://leetcode.com/problems/decode-ways/
// O(n) time-and-space
class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int n = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];
            if (n >= 10 && n <= 26)
                dp[i] += (i > 1 ? dp[i - 2] : 1);
        }
        return dp[dp.length - 1];
    }
}

class SolutionTopDown {
    Integer[] memo;

    public int numDecodings(String s) {
        memo =  new Integer[s.length()];
        return dfs(s, 0);
    }
    
    int dfs(String s, int i) {
        if (i == s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (memo[i] != null)
            return memo[i];
        int c = dfs(s, i + 1);
        if (s.length() - i >= 2) {
            int n = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if (n >= 1 && n <= 26)
                c += dfs(s, i + 2);
        }
        memo[i] = c;
        return c;
    }
}
