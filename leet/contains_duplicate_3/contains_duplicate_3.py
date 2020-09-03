from typing import List
import bisect

class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if not nums:
            return False
        if k == 0 or len(nums) < 2:
            return False
        i = 0
        s = sorted(nums[:k + 1])
        for j in range(len(s) - 1):
                if s[j + 1] - s[j] <= t:
                    #print(s[1], s[0], "or", s[-1], s[-2], "Match")
                    return True
        while True:
            #print("CHECKING", s)
            if i + k + 1 >= len(nums):
                break;
            #print("REMOVING", nums[i], "ADDING", nums[i + k + 1])
            s.remove(nums[i])
            x = bisect.bisect_left(s, nums[i + k + 1])
            #print("X", x, s)
            if abs(nums[i + k + 1] - s[x - 1]) <= t or abs(s[x if x < len(s) else x - 1] - nums[i + k + 1]) <= t:
                return True
            if x == 0:
                s = [nums[i + k + 1]] + s
            elif x == len(s):
                s = s + [nums[i + k + 1]]
            else:
                s = s[:x] + [nums[i + k + 1]] + s[x:]
            i +=1
        return False

data = [1,2,3,1]
k = 3
t = 0
#print("Solution to", data, k, t, Solution().containsNearbyAlmostDuplicate(data, k, t))
data = [1,0,1,1]
k = 1
t = 2
#print("Solution to", data, k, t, Solution().containsNearbyAlmostDuplicate(data, k, t))
data = [1,5,9,1,5,9]
k = 2
t = 3
#print("Solution to", data, k, t, Solution().containsNearbyAlmostDuplicate(data, k, t))

data = [7,2,8]
k = 2
t = 1
#print("Solution to", data, k, t, Solution().containsNearbyAlmostDuplicate(data, k, t))

data = [3,6,0,4]
k = 2
t = 2
#print("Solution to", data, k, t, Solution().containsNearbyAlmostDuplicate(data, k, t))