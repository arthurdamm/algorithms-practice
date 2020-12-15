# LeetCode 977. Squares of a Sorted Array
# O(n) time O(n) space
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        ret = [0] * len(nums)
        i, j, k, = 0, len(nums) - 1, len(nums) - 1
        while i <= j:
            if abs(nums[i]) > nums[j]:
                ret[k] = nums[i] * nums[i]
                i += 1
            else:
                ret[k] = nums[j] * nums[j]
                j -= 1
            k -= 1
        return ret

