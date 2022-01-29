// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(nlogn) time, O(n) space QUICKSORT LOMUTO
class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    
    void quicksort(int[] A, int lo, int hi) {
        if (lo >= hi || lo < 0) return;
        int p = partition(A, lo, hi);
        quicksort(A, lo, p - 1);
        quicksort(A, p + 1, hi);
    }
    
    int partition(int[] A, int lo, int hi) {
        int pivot = A[hi], i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (A[j] <= pivot)
                swap(A, ++i, j);
        }
        swap(A, ++i, hi);
        return i;
    }
    
    void swap(int []A, int i, int j) {
        if (i == j) return;
        A[i] ^= A[j];
        A[j] ^= A[i];
        A[i] ^= A[j];
    }
}
