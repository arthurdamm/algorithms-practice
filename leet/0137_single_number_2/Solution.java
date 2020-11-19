// LeetCode 137. Single Number II
// O(n) time, O(1) space

class Solution {
    public int singleNumber(int[] nums) {
        int k = 3, ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums)
                count += (num >> i) & 1;
            if (count % k != 0)
                ans |= 1 << i;
        }
        return ans;
    }
}
