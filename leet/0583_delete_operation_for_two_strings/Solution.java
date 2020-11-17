class Solution {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * LCS(word1, word2);
    }
    
    public int LCS(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        int i = 0, j = 0;
        for (i = 1; i <= text1.length(); i++) {
            for (j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
    
}
