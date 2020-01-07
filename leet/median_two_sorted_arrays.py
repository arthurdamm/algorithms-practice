# LeetCode 4. Median of Two Sorted Arrays
# O(log(min(n, m))) time complexity, O(1) space

from typing import List

class Solution:
  def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
    if not len(nums1) or not len(nums2):
      if not len(nums1):
        nums1 = nums2
      else:
        nums2 = nums1
    if len(nums1) > len(nums2):
      nums1, nums2 = nums2, nums1
    lo, hi = 0, len(nums1) - 1
    while True:
      x = (lo + hi) // 2
      y = (len(nums1) + len(nums2) + 1) // 2 - x
      #print("lo", lo, "hi", hi, "x", x, "y", y)
      
      xleft = nums1[x - 1] if x > 0 else float('-inf')
      xright = nums1[x] if x < len(nums1) else float('inf')
      yleft = nums2[y - 1] if y > 0 else float('-inf')
      yright = nums2[y] if y < len(nums2) else float('inf')
      if xleft <= yright and yleft <= xright: # found
        if (len(nums1) + len(nums2)) % 2 == 0:
          return (max(xleft, yleft) + min(xright, yright)) / 2
        else:
          return max(xleft, yleft)
      elif xright < yleft: # move x right
        if x == hi:
          hi += 1
        lo = x + 1
      else:
        hi = x - 1

if __name__ == "__main__":
  n1 = [1, 3]
  n2 = [2]
  print("Solution to", n1, n2, ":", Solution().findMedianSortedArrays(n1, n2))

  n1 = [1, 2, 3]
  n2 = [4, 5, 6, 7]
  print("Solution to", n1, n2, ":", Solution().findMedianSortedArrays(n1, n2))

  n1 = [2]
  n2 = []
  print("Solution to", n1, n2, ":", Solution().findMedianSortedArrays(n1, n2))
