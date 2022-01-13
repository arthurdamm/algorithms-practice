# LeetCode 452. Minimum Number of Arrows to Burst Balloons
# https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
# O(nlogn) time, O(1) space
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        intervals = 1
        b1, b2 = points.pop()
        while len(points):
            a1, a2 = points.pop()
            # second condition is already guaranteed by sort
            if a2 >= b1 and a1 <= b2:
                b1 = max(a1, b1)
                b2 = min(a2, b2)
            else:
                b1, b2, = a1, a2
                intervals += 1
        return intervals
