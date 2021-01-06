// LeetCode 978. Longest Turbulent Subarray
// https://leetcode.com/problems/longest-turbulent-subarray/
// O(n) time, O(1) space
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1, start = 0;
        if (arr.length > 1) {
            if (arr[0] == arr[1])
                start = 1;
            else
                max = 2;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                max = Math.max(max, i - start);
                start = i;
            } else if(((arr[i - 2] < arr[i - 1] && arr[i - 1] < arr[i])
                           || (arr[i - 2] > arr[i - 1] && arr[i - 1] > arr[i]) )) {
                max = Math.max(max, i - start);
                start = i - 1;
            }   
        }
        return max = Math.max(max, arr.length - start);
    }
}
