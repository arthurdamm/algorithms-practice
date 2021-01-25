// LeetCode 1545. Find Kth Bit in Nth Binary String
// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
// O(n) time, O(1) space
class Solution {
    
    public char findKthBit(int n, int k) {
        if (n <= 2)
            return k == 1 ? '0' : '1';
        int lenS = (2 << (n - 1)) - 1;
        int mid = (lenS + 1) / 2, midOfSecondHalf = mid + mid / 2;
        if (k == mid)
            return '1';
        if (k == midOfSecondHalf)
            return '0';
        return findKthBit(n - 1, k % mid);
    }
}
