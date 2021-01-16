// LeetCode 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/
// O(n) time O(1) space
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
