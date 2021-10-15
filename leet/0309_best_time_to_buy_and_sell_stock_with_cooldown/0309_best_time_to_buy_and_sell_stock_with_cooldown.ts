// LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// O(n) time-and-space
function maxProfit(prices: number[]): number {
    const buy = Array(prices.length).fill(0);
    const sell = Array(prices.length).fill(0);
    buy[0] = -prices[0];
    for (let i = 1; i < prices.length; i++) {
        buy[i] = Math.max(buy[i-1], (i > 1 ? sell[i-2] : 0) - prices[i]);
        sell[i] = Math.max(sell[i-1], i > 0 ? buy[i-1] + prices[i] : 0);
    }
    return sell[prices.length - 1];
};

