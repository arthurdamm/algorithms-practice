from typing import List

class Solution:
	def pancakeSort(self, A: List[int]) -> List[int]:
		last = len(A)
		flips = []
		for _ in range(len(A)):
			flips.append(A.index(max(A[:last]), 0, last) + 1)
			A = list(reversed(A[0:flips[-1]])) + A[flips[-1]:]
			flips.append(last)
			A = list(reversed(A[0:flips[-1]])) + A[flips[-1]:]
			last -= 1
		return flips

Solution().pancakeSort([5,3,2,4,6,1])
