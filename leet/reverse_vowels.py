# LeetCode 345 Reverse Vowels in String

class Solution:
    def reverseVowels(self, s: str) -> str:
        if s == "": return ""
        s = list(s)
        vowels = set("aeiouAEIOU")
        i = 0
        j = len(s) - 1
        while i < j:
            while i <= j and s[i] not in vowels:
                i += 1
            while i <= j and s[j] not in vowels:
                j -= 1
            if i < j:
                s[i], s[j] = s[j], s[i]
                i += 1
                j -= 1
        return str("".join(s))


if __name__ == "__main__":
    s = "leetcode"
    print("Solution to", s, ":", Solution().reverseVowels(s))

    s = "b"
    print("Solution to", s, ":", Solution().reverseVowels(s))
   
    s = "aei"
    print("Solution to", s, ":", Solution().reverseVowels(s))
