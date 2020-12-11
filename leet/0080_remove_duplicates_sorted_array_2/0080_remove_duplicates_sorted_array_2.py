# LeetCode 80. Remove Duplicates from Sorted Array II
# O(n) time O(1) space
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        i, j = 0, 1
        while j < len(nums):
            if nums[i] == nums[j]:
                k = j + 1
                while k < len(nums) and nums[k] == nums[j]:
                    k += 1
                j = k - 1
            i += 1
            nums[i] = nums[j]
            j += 1
        return i + 1
