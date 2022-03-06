/*
LeetCode 1359. Count All Valid Pickup and Delivery Options
https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
O(n) time, O(1) space
Key Insight: update total by one pair at a time. For given sequence of length i,
there will be nCr(i + 2, 2) ways of inserting the new (P,D)pair; multiplied by
the previous total.
*/
var countOrders = function(n) {
    const MOD = 1000000007
    let total = 1;
    for (let i = 1; i < n; i++) {
        const seqLength = i * 2 + 2;
        total *= nC2(seqLength);
        total %= MOD;
    }
    
    function nC2(n) {
        return n * (n - 1) / 2;
    }
    
    return total;
};
