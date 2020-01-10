# LeetCode 5. Longest Palindromic Substring
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s: return ""
        if len(s) == 1: return s
        max_pal_sz = 0
        max_pal = None
        for i in range(len(s)):
            if i > 0 and s[i - 1] == s[i]:
                sz = self.findPal(s, i + 1, i - 2)
                if sz > max_pal_sz:
                    max_pal_sz = sz
                    max_pal = s[i - sz // 2: i + sz // 2]
            if i > 1 and s[i - 2] == s[i]:
                sz = self.findPal(s, i + 1, i - 3)
                if sz > max_pal_sz:
                    max_pal_sz = sz
                    max_pal = s[i - 1 - sz // 2: i + sz // 2]
        return max_pal if max_pal else s[0]
    
    def findPal(self, s, i, j):
        while i < len(s) and j >= 0 and s[i] == s[j]:
            i += 1
            j -= 1
        return i - j - 1


if __name__ == "__main__":
  s = "aaaa"
  print("Solution to", s, ":", Solution().longestPalindrome(s))
