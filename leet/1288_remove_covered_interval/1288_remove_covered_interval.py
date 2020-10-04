# LeetCode 1288. Remove Covered Intervals
# O(nlogn) time, O(1) space
class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        curr = intervals[0]
        i = 1
        size = len(intervals)
        while i < len(intervals):
            if curr[0] <= intervals[i][0] and curr[1] >= intervals[i][1]:
                size -= 1
            else:
                curr = intervals[i]
            i += 1
        return size
