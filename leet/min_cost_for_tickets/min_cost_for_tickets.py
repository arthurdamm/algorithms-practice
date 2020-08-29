# LeetCode #983. Minimum Cost For Tickets
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * 366
        days_set = set(days)
        for i in range(1, len(dp)):
            if i not in days_set:
                dp[i] = dp[i - 1]
                continue
            dp[i] = dp[i - 1] + costs[0]
            dp[i] = min(dp[i], dp[i - 7] + costs[1])
            dp[i] = min(dp[i], dp[i - 30] + costs[2])
        return dp[-1]
