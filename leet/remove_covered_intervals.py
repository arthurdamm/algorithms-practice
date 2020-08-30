# LeetCode 1288. Remove Covered Intervals
import heapq

class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) < 2:
            return len(intervals)
        heapq.heapify(intervals)
        remaining = 1
        a = heapq.heappop(intervals)
        for _ in range(len(intervals)):
            b = heapq.heappop(intervals)
            if a[0] == b[0]:
                if a[1] < b[1]:
                    a = b
            elif a[1] < b[1]:
                remaining += 1
                a = b
        return remaining

