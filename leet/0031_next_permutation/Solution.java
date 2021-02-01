// LeetCode 31. Next Permutation
// https://leetcode.com/problems/next-permutation/
// O(n) time, O(1) space
class Solution {
    public void nextPermutation(int[] nums) {
        int smaller = nums.length - 2;
        while (smaller >= 0 && nums[smaller] >= nums[smaller + 1])
            smaller--;
        if (smaller == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int nextBigger = -1;
        for (int i = nums.length - 1; i > smaller; i--) {
            if (nums[i] > nums[smaller] && (nextBigger == -1 || nums[i] < nums[nextBigger]))
                nextBigger = i;
        }
        nums[smaller] ^= nums[nextBigger];
        nums[nextBigger] ^= nums[smaller];
        nums[smaller] ^= nums[nextBigger];
        reverse(nums, smaller + 1, nums.length - 1);
    }
    
    void reverse(int nums[], int start, int stop) {
        for (int i = 0; i < (stop - start + 1) / 2; i++) {
            nums[start + i] ^= nums[stop - i];
            nums[stop - i] ^= nums[start + i];
            nums[start + i] ^= nums[stop - i];
        }
    }
}
