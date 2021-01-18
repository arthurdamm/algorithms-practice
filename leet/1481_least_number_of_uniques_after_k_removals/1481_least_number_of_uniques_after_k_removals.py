# LeetCode 1481. Least Number of Unique Integers after K Removals
# https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
# O(nlogm) time, O(n + m) space
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
    	counter = Counter(arr)
    	maxheap = []
    	for count in counter.values():
    		if count <= k:
    			k -= count
    			heapq.heappush(maxheap, -count)
    		elif len(maxheap) and count < -maxheap[0]:
    			k += -heapq.heappop(maxheap)
    			k -= count
    			heapq.heappush(maxheap, -count)
    	return len(counter) - len(maxheap)
