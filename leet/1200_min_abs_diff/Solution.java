// LeetCode 1200. Minimum Absolute Difference
// https://leetcode.com/problems/minimum-absolute-difference/
// O(nlogn) time, O(n) space
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++)
            minDiff = Math.min(arr[i] - arr[i - 1], minDiff);
        List<List<Integer>> ret = new ArrayList();
        for (int i = 1; i < arr.length; i++)
            if (arr[i] - arr[i - 1] == minDiff)
                ret.add(Arrays.asList(arr[i - 1], arr[i]));
        return ret;
    }
}
