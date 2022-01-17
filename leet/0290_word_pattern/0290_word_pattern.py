# LeetCode 290. Word Pattern
# O(n) time-and-space
class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        char_to_word = {}
        word_to_char = {}
        words = str.split(" ")
        if len(pattern) != len(words):
            return False
        for char, word in zip (list(pattern), words):
            if char not in char_to_word:
                if word in word_to_char:
                    return False
                char_to_word[char] = word
                word_to_char[word] = char
            else:
                if word not in word_to_char or char_to_word[char] != word:
                    return False
        return True
