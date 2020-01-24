# LeetCode 27. Remove Element

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums: return 0
        i = 0
        for num in nums:
            if num != val:
                nums[i] = num
                i += 1
        return i

