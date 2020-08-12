#!/usr/bin/env python3
class Solution:
    def hIndex(self, citations) -> int:
        citations.sort(reverse=True)
        h = 0
        for citation in citations:
            if citation <= h:
                break
            h += 1
        return h

input = [3,0,6,1,5]
print("Solution to", input, Solution().hIndex(input))
