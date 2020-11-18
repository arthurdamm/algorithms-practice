// LeetCode 56. Merge Intervals
// O(n) time O(n) space

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        int[] last = intervals[0];
        merged.add(last);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] <= last[1])
                last[1] = Math.max(last[1], intervals[i][1]);
            else
                merged.add(last = intervals[i]);
        return merged.toArray(new int[merged.size()][]);
    }
}
