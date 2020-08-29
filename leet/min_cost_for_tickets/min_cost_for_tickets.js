// LeetCode #983. Minimum Cost For Tickets
/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
    let daySet = new Set(days);
    let dp = new Array(366).fill(0);
    for (let i = 1; i < 366; i++) {
        if (!daySet.has(i))
            dp[i] = dp[i - 1];
        else
            dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0],
                            dp[Math.max(0, i - 7)] + costs[1],
                            dp[Math.max(0, i - 30)] + costs[2]);
    }
    return dp[365];
};
