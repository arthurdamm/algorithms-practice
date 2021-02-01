# LeetCode 31. Next Permutation
# https://leetcode.com/problems/next-permutation/
# O(n) time, O(1) space
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        smaller = None
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                smaller = i
                break
        if smaller == None:
            nums.reverse()
            return
        nextBigger = None
        for i in range(len(nums) - 1, smaller, -1):
            if nums[i] > nums[smaller] and (nextBigger == None or nums[i] < nums[nextBigger]):
                nextBigger = i
        nums[smaller], nums[nextBigger] = nums[nextBigger], nums[smaller]
        for i in range((len(nums) - smaller - 1) // 2):
            nums[smaller + 1 + i], nums[-(i + 1)] = nums[-(i + 1)], nums[smaller + 1 + i]
