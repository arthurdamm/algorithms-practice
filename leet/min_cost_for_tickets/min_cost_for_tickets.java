// LeetCode #983. Minimum Cost For Tickets
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<Integer>(Arrays.stream(days).boxed().collect(Collectors.toList()));
        int[] dp = new int[366];
        for (int i = 1; i < 366; i++)
        {
            if (!daySet.contains(i))
                dp[i] = dp[i - 1];
            else
            {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            }
        }
        return dp[365];
    }
}
