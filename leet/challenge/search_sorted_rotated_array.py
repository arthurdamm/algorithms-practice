#!/usr/bin/env python3
"""
Search in rotated sorted array
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if target == nums[mid]:
                return mid
            if target > nums[mid]:
                if nums[mid] < nums[hi]:
                    if target > nums[hi]:
                        hi = mid - 1
                    else:
                        lo = mid + 1
                else:
                    lo = mid + 1
            else:
                if nums[mid] > nums[lo]:
                    if target < nums[lo]:
                        lo = mid + 1
                    else:
                        hi = mid - 1
                else:
                    if target < nums[hi]:
                        hi = mid - 1
                    else:
                        lo = mid + 1
        return -1
