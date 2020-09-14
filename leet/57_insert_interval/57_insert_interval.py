# LeetCode #57. Insert Interval
# O(n) time, O(1) space
from typing import List
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        for i in range(len(intervals)):
            # find first i whose end-time is >= to new start
            if intervals[i][1] >= newInterval[0]:
                # if start-time is > than new end, insert alone before i
                if intervals[i][0] > newInterval[1]:
                    intervals = intervals[:i] + [newInterval] + intervals[i:]
                    return intervals
                # if start-time is > than new start, change start time
                if intervals[i][0] > newInterval[0]:
                    intervals[i][0] = newInterval[0]
                # iterate from i until finding end-time is >= new end
                for j in range(i, len(intervals)):
                    if intervals[j][1] >= newInterval[1]:
                        # if start time is > new end, merge up to last
                        if intervals[j][0] > newInterval[1]:
                            # set ith end-time to new end time
                            intervals[i][1] = newInterval[1]
                            intervals[i + 1: j] = []
                            return intervals
                        else:
                            # set end time of i'th interval to b's end time
                            intervals[i][1] = intervals[j][1]
                            intervals[i + 1: j + 1] = []
                            return intervals
                        return
                # new end greater than any other interval
                intervals[i][1] = newInterval[1]
                b = len(intervals)
                intervals[i + 1: b] = []
                return intervals
        # new interval is largest append to end
        intervals += [newInterval]
        return intervals

if __name__ == "__main__":
  intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
  newInterval = [4,8]
  print("Solution to", intervals, newInterval, "is",
      Solution().insert(intervals, newInterval))
