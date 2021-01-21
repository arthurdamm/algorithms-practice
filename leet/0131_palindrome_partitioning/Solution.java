// LeetCode 131. Palindrome Partitioning
// https://leetcode.com/problems/palindrome-partitioning/
// O(n*2^n) time-and-space, bottom-up DP + backtracking
class Solution {
    List<List<String>> partitions = new ArrayList<>();
    ArrayList<String> dp[];
    char str[];
    
    public List<List<String>> partition(String s) {
        str = s.toCharArray();
        dp = new ArrayList[str.length];
        for (int i = 0; i < str.length; i++) {
            dp[i] = new ArrayList<>();
            populatePalindromes(s, i, i);
            populatePalindromes(s, i, i + 1);
        }
        backtrack(str, 0, new ArrayList<>());
        return partitions;
    }
    
    void populatePalindromes(String s, int i, int j) {
        while (i >= 0 && j < str.length && str[i] == str[j])
            dp[i].add(s.substring(i--, j++ + 1));
    }
    
    void backtrack(char str[], int i, ArrayList<String> partition) {
        if (i == str.length) {
            partitions.add(new ArrayList<>(partition));
            return;
        }
        for (String palindrome : dp[i]) {
            partition.add(palindrome);
            backtrack(str, i + palindrome.length(), partition);
            partition.remove(partition.size() - 1);
        }
    }
}
