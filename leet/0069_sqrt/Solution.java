// LeetCode 69. Sqrt(x)
// https://leetcode.com/problems/sqrtx/
// O(log(n)) time, O(1) space
class Solution {
    public int mySqrt(int x) {
        long lo = 0, hi = (long)x + 1, root = 0;
        while (lo < hi) {
            long mid = (hi - lo) / 2 + lo;
            if (mid * mid > x)
                hi = mid;
            else {
                root = mid;
                lo = mid + 1;
            }
        }
        return (int)root;
    }
}
