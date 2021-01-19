// LeetCode 139. Word Break
// https://leetcode.com/problems/word-break/
// O(m*n*o) time, O(m) space
class SolutionBottomUp {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++) {
            if (!dp[i])
                continue;
            for (String word : wordDict)
                if (s.regionMatches(i, word, 0, word.length()))
                    dp[i + word.length()] = true;
        }
        return dp[dp.length - 1];
    }
}

