// LeetCode 231. Power of Two
// https://leetcode.com/problems/power-of-two/
// O(1) time-and-space
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & -n) == n;
    }
};
