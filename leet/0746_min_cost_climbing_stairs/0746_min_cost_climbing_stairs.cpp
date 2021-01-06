// LeetCode 746. Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/
// O(n) time O(1) space
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        for (int i = 2; i < cost.size(); i++)
            cost[i] = min(cost[i - 1], cost[i - 2]) + cost[i];
        return min(cost[cost.size() - 1], cost[cost.size() - 2]);
    }
};

// LeetCode 746. Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/
// O(n) time O(n) space
class SolutionTopDown {
public:
    int *memo;
    vector<int> cost;
    int minCostClimbingStairs(vector<int>& cost) {
        int memo[cost.size()];
        memset(memo, 0xFF, cost.size() * sizeof(int));
        this->memo = memo, this->cost = cost;
        memo[0] = cost[0], memo[1] = cost[1];
        return min(dp(cost.size() - 1), dp(cost.size() - 2));
    }
    
    int dp(int i) {
        if (i < 0) return 0;
        if (memo[i] == -1)
            memo[i] = min(dp(i - 1), dp(i - 2)) + cost[i];
        return memo[i];
    }
};
