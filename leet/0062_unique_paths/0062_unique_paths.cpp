// LeetCode 62. Unique Paths
// https://leetcode.com/problems/unique-paths/
// O(m*n) time, O(m*n) space
#include <string.h>
#include <iostream>
using namespace std;

class Solution {
public:
    unsigned long uniquePaths(int m, int n) {
        unsigned long dp[m][n];
        memset(dp, 0, m*n*8);
        dp[0][0] = 1;
        return topDown(m - 1, n - 1, (unsigned long*)dp, n);
    }
    
    unsigned long topDown(int i, int j, unsigned long* dp, int n) {
        if (i < 0 || j < 0)
            return 0;
        if (!dp[j + i*n]) // if (!dp[i][j])
            dp[j + i*n] = topDown(i - 1, j, dp, n) + topDown(i, j - 1, dp, n);
        return dp[j + i*n];
        
    }
};

int main(void) {
    Solution *s = new Solution();
    cout << s->uniquePaths(21, 21) << endl;
    return (0);
}
