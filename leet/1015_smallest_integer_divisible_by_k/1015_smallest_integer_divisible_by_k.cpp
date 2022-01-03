// LeetCode 1015. Smallest Integer Divisible by K
// https://leetcode.com/problems/smallest-integer-divisible-by-k/
// O(k) time, O(1) space
class Solution {
public:
    int smallestRepunitDivByK(int k) {
        int length = 1, n = 1;
        for (length = 1; length <= k; length++) {
            if (n % k == 0)
                return length;
            n = (10 * n + 1) % k;
        }
        return -1;
    }
};
