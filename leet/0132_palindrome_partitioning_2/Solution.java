// LeetCode 132. Palindrome Partitioning II
// https://leetcode.com/problems/palindrome-partitioning-ii/
// O(n^3) time, O(1) space, bottom-up DP + backtracking
class Solution {
    ArrayList<Integer> dp[];
    char str[];
    
    public int minCut(String s) {
        str = s.toCharArray();
        dp = new ArrayList[str.length];
        for (int i = 0; i < str.length; i++) {
            dp[i] = new ArrayList<>();
            populatePalindromes(s, i, i);
            populatePalindromes(s, i, i + 1);
        }
        
        int dpCuts[] = new int[dp.length + 1];
        Arrays.fill(dpCuts, str.length);
        dpCuts[dpCuts.length - 1] = 0;
        for (int i = dpCuts.length - 2; i >= 0; i--)
            for (int length : dp[i])
                dpCuts[i] = Math.min(dpCuts[i], 1 + dpCuts[i + length]);
        return dpCuts[0] - 1;
    }
    
    void populatePalindromes(String s, int i, int j) {
        while (i >= 0 && j < str.length && str[i] == str[j])
            dp[i].add(j++ + 1 - i--);
    }
}
