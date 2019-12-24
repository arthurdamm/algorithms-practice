#!/usr/bin/env python3
# LeetCode Boats to Save People
# O(nlogn) time complexity, O(1) space complexity if in-place sort

from typing import List;

class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        if not people: return 0
        if len(people) == 1: return 1
        people.sort()
        start, back = 0, len(people) - 1
        boats = 0
        while (start <= back):
            if people[start] + people[back] <= limit:
                start += 1
                back -= 1
            else:
                back -= 1
            boats += 1
        return boats
        
if __name__ == "__main__":
    print(Solution().numRescueBoats([3,2,2,1], 3))
