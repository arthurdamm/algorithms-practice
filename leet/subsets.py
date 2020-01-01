# LeetCode 78 Subsets
# O(2^n) solution

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        self.findSubsets(nums, 0, [], subsets)
        return subsets
    
    def findSubsets(self, nums, index, current, subsets):
        print("find", index, current)
        current = current[:]
        subsets.append(current)
        for i in range(index, len(nums)):
            current.append(nums[i]);
            self.findSubsets(nums, i + 1, current, subsets)
            current.pop();

if __name__ == "__main__":
    d = [1, 2, 3]
    print("Solution to", d, ":", Solution().subsets(d))
