// LeetCode 1680. Concatenation of Consecutive Binary Numbers
// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
// O(n) time, O(1) space
class Solution {
    public int concatenatedBinary(int n) {
        long k = 1, MOD = (int)1e9 + 7;
        for (Integer i = 2; i <= n; i++)
            k = (k * Integer.highestOneBit(i) * 2 + i) % MOD;
        return (int)k;
    }
}
