// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/
// O(n^2) time-and-space, bottom-up DP
class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[str.length][str.length];
        int maxI = -1, maxJ = -1;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j + i < str.length; j++) {
                if (i <= 1)
                    dp[j][j + i] = str[j] == str[j + i];
                else
                    dp[j][j + i] = str[j] == str[j + i] && dp[j + 1][j + i - 1];
                if (dp[j][j + i] && i > maxI) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }                    
        return s.substring(maxJ, maxJ + maxI + 1);
    }
}

// O(n^2) time, O(1) space, Circle-Out (Expand Around Center)
// 2n - 1 (n + n - 1) palindrome centers 
class Solution {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int maxSZ = 1, maxI = 0, sz = 1;
        for (int i = 1; i < str.length; i++) {
            sz = Math.max(maxPali(str, i - 1, i),
                          maxPali(str, i - 2, i));
            if (sz > maxSZ) {
                maxSZ = sz;
                maxI = i - (sz + 1) / 2;
            }
        }
        return s.substring(maxI, maxI + maxSZ);
    }

    int maxPali(char[] str, int i, int j) {
        while (i >= 0 && j < str.length && str[i] == str[j]) {
            i -= 1;
            j += 1;
        }
        return j - i - 1;
    }
}
