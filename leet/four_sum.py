# LeetCode 18. 4Sum

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) < 4: return []
        sol = set()
        nums.sort()
        for i in range(len(nums) - 3):
            for j in range(i + 1, len(nums) - 2):
                k = j + 1
                l = len(nums) - 1
                while k < l:
                    sumfour = nums[i] + nums[j] + nums[k] + nums[l]
                    if sumfour > target:
                        l -= 1
                    elif sumfour < target:
                        k += 1
                    else:
                        sol.add((nums[i], nums[j], nums[k], nums[l]))
                        k += 1
                        l -= 1
        return sol

