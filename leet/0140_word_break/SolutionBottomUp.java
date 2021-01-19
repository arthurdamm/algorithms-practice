// LeetCode 140. Word Break II
// https://leetcode.com/problems/word-break-ii/
// O(m*n*o) time, O(m*n*o) space
class Solution {
    List<String> ret = new ArrayList<>();
    List<String> dp[];
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;
            for (String word : wordDict)
                if (s.regionMatches(i, word, 0, word.length())) {
                    if (dp[i + word.length()] == null)
                        dp[i + word.length()] = new ArrayList<>();
                    dp[i + word.length()].add(word);
                }
        }
        if (dp[dp.length - 1] == null)
            return ret;
        getWords(dp.length - 1, new StringBuilder());
        return ret;
    }
    
    void getWords(int i, StringBuilder sb) {
        if (i == 0) {
            ret.add(sb.toString());
            return;
        }
        for (String word : dp[i]) {
            if (i != dp.length - 1)
                sb.insert(0, ' ');
            sb.insert(0, word);
            getWords(i - word.length(), sb);
            sb.delete(0, word.length());
            if (i != dp.length - 1)
                sb.delete(0, 1);
        }
    }
}
