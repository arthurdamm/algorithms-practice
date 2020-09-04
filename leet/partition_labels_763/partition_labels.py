"""
LeetCode #763 Parition Labels: O(n) time O(n) space

A string S of lowercase English letters is given. We want to partition this
string into as many parts as possible so that each letter appears in at most one
part, and return a list of integers representing the size of these parts.
"""

from typing import List

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        partitions = []
        last_position = {}
        for i, n in enumerate(S):
            last_position[n] = i
        start = 0
        end = -1
        for i, n in enumerate(S):
            end = max(end, last_position[n])
            if i == end:
                partitions.append(end + 1 - start)
                start = end + 1
        return partitions

if __name__ == "__main__":
    S = "ababcbacadefegdehijhklij"
    result = Solution().partitionLabels(S)
    print("Solution to", S, result)
    assert result == [9,7,8]
