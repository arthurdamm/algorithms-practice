// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(nlogn) time, O(n) space MERGE SORT
class Solution {
    public int[] sortArray(int[] nums) {
        int[] B = new int[nums.length];
        System.arraycopy(nums, 0, B, 0, nums.length);
        TopDownSplitMerge(nums, B, 0, nums.length);
        return nums;
    }
    
    void TopDownSplitMerge(int[] A, int B[], int start, int end) {
        if (end - start <= 1)
            return;
        int mid = start + (end - start) / 2;
        TopDownSplitMerge(B, A, start, mid);
        TopDownSplitMerge(B, A, mid, end);
        TopDownMerge(A, B, start, mid, end);
    }
    
    void TopDownMerge(int[] A, int[] B, int start, int mid, int end) {
        for (int i = start, j = mid, k = start; k < end; k++) {
            if (i < mid && (j == end || B[i] <= B[j]))
                A[k] = B[i++];
            else
                A[k] = B[j++];
        }
    }
}
