class Solution:
    def sortColors(self, nums: List[int]) -> None:
        beg = 0
        end = len(nums) - 1
        i = beg
        while i <= end:
            temp = nums[i]
            if nums[i] == 0:
                nums[i] = nums[beg]
                nums[beg] = temp
                beg += 1
            elif nums[i] == 2:
                nums[i] = nums[end]
                nums[end] = temp
                end -= 1
                i -= 1
            i += 1
