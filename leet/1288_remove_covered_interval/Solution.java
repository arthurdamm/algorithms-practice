// LeetCode 1288. Remove Covered Intervals
// O(nlogn) time, O(1) space
import java.util.Arrays;

class Solution {
    public static void main(String args[]) {
        int intervals[][] = {{5, 15}, {5, 8}, {6, 11}, {6, 10}, {8, 18}, {9, 19}, {9, 15}, {9, 13}, {9, 11}, {10, 19}};
        System.out.println(new Solution().removeCoveredIntervals(intervals));
        System.out.println(Arrays.deepToString(intervals));
    }
    public int removeCoveredIntervals(int[][] intervals) {      
        Arrays.sort(intervals, (int[] a, int[] b) ->
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int i = 0, j = 1, size = intervals.length;
        for(; j < intervals.length; j++)
            if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1])
                size--;
            else
            	i = j;
        return size;
    }
}
