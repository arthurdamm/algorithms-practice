// LeetCode 260. Single Number III
// O(n) time, O(1) space

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;
        int a = 0, b = 0;
        int bit = xor & -xor;
        for (int n : nums)
            if ((bit & n) != 0)
                a ^= n;
            else
                b ^= n;
        return new int[] {a, b};
    }
}
