// LeetCode 231. Power of Two
// https://leetcode.com/problems/power-of-two/
// O(1) time-and-space
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
