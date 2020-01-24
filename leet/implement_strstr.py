# LeetCode 28. Implement strStr()

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle: return 0
        i = 0
        while len(haystack) - i >= len(needle):
            if haystack[i] == needle[0]:
                j = 1
                _i = i
                i += 1
                while i < len(haystack) and j < len(needle) and haystack[i] == needle[j]:
                    i += 1
                    j += 1
                if j == len(needle):
                    return _i
                else:
                    i = _i
            i += 1
        return -1

