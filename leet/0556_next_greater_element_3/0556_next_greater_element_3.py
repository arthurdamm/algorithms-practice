# LeetCode 556. Next Greater Element III
# https://leetcode.com/problems/next-greater-element-iii/
# O(dlogd) time, O(d) space, where d is number of digits
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        l = list(str(n))
        j = len(l) - 1
        _max = float('-inf')
        for i in range(len(l) - 1, -1, -1):
            if l[i] >= l[j]:
                j = i
            elif l[i] < l[j]:
                jj = j
                for ii in range(len(l) -1, i - 1, -1):
                    if l[ii] > l[i] and l[ii] <= l[jj]:
                        jj = ii
                j = jj
                l[i], l[j] = l[j], l[i]
                l[i + 1:] = sorted(l[i + 1:])
                break
        n2 = int("".join(l))
        if n2 > n and n2 <= 2**31 - 1:
            return n2
        return -1
