#!/usr/bin/env python3
# LeetCode Meeting Rooms 2
# O(nlogn) solution

from heapq import *;

class Solution:
  def minMeetingRooms(self, intervals):
    if not intervals: return 0
    intervals.sort(key=lambda x:x[0])
    pqueue = []
    heappush(pqueue, (intervals[0][1], intervals[0][0]))
    for i in range(1, len(intervals)):
      earliest = heappop(pqueue)
      if intervals[i][0] >= earliest[0]:
        earliest = (intervals[i][1], earliest[1])
      else:
        heappush(pqueue, (intervals[i][1], intervals[i][0]))
      heappush(pqueue, earliest)
    return len(pqueue)

if __name__ == "__main__":
  d = []
  print("Solution for ", d, ":", Solution().minMeetingRooms(d))
  d = [(1, 4), (5, 6), (8, 9), (2, 6)]
  print("Solution for ", d, ":", Solution().minMeetingRooms(d))
  d = [[0, 30], [5, 10], [15, 20]]
  print("Solution for ", d, ":", Solution().minMeetingRooms(d))
  d = [[7, 10], [2, 4]]
  print("Solution for ", d, ":", Solution().minMeetingRooms(d))
