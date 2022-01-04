// 1009. Complement of Base 10 Integer
// https://leetcode.com/problems/complement-of-base-10-integer/
// O(1) time-and-space
class Solution {
    public int bitwiseComplement(int n) {
        int k = n | 1;
        k |= k >> 1;
        k |= k >> 2;
        k |= k >> 4;
        k |= k >> 8;
        k |= k >> 16;
        return k & ~n;
    }
}
