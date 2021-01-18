// LeetCode 1539. Kth Missing Positive Number
// https://leetcode.com/problems/kth-missing-positive-number/
// O(logn) time, O(1) space
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return k + lo;
    }
}
