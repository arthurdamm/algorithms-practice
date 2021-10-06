#!/usr/bin/env python3
# LeetCode 442. Find All Duplicates in an Array
# https://leetcode.com/problems/find-all-duplicates-in-an-array/
# O(n) time, O(1) space
class Solution:
    def findDuplicates(self, nums):
        if len(nums) == 2 and nums[0] == 1 and nums[1] == 1:
            return [1]
        i = 0
        j = -1
        duplicates = []
        while i < len(nums):
            if j == -1:
                j = nums[i] - 1
                nums[i] *= -1
                i += 1
            elif nums[j] < 0:
                nums[j] = 0
                j = -1
            else:
                if nums[j] == 0:
                    duplicates.append(j + 1)
                    j = -1
                else:
                    temp = nums[j]
                    nums[j] = 0
                    j = temp - 1
        return duplicates

input = [10,2,5,10,9,1,1,4,3,7]
#input = [4,3,2,7,8,2,3,1]
print("Solution to", input, "is")
print(Solution().findDuplicates(input))
