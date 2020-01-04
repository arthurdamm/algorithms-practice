# LeetCode 14 Longest Common Prefix
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ret = ""
        if not strs: return ret
        sz = min([len(s) for s in strs])
        for i in range(sz):
            c = strs[0][i]
            for s in strs[1:]:
                if c != s[i]:
                    return ret
            ret += c
        return ret
