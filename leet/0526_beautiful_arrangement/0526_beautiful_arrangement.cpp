// LeetCode 526. Beautiful Arrangement
// https://leetcode.com/problems/beautiful-arrangement/
// O(N*2^N) time, O(2^N) space
class Solution {
public:
    int countArrangement(int n) {
        int memo[1 << n];
        memset(memo, 0xff, (1 << n) * sizeof(int));
        return dfs(n, n, 0, memo);
    }
    
    int dfs(int n, int i, int used, int *memo) {
        if (i == 0)
            return 1;
        if (memo[used] != -1)
            return memo[used];
        memo[used] = 0;
        for (int j = n; j >= 1; j--)
            if ((i % j == 0 || j % i == 0 ) && (((1 << (j - 1)) & used) == 0))
                memo[used] += dfs(n, i - 1, used | (1 << (j - 1)), memo);
        return memo[used];
    }
};
