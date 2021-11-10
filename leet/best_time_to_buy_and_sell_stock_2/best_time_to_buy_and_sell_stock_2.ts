// LeetCode 122. Best Time to Buy and Sell Stock II
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// O(n) time, O(1) space
function maxProfit(prices: number[]): number {
    let minSeen = Number.MAX_SAFE_INTEGER, profit = 0;
    for (const price of prices) {
        if (minSeen < price)
            profit += price - minSeen;
        minSeen = price;
    }
    return profit;
};

