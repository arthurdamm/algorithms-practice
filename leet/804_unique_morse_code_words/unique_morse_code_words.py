# LeetCode 804. Unique Morse Code Words
# O(nm) time & space
class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        l = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        toMorse = lambda word: "".join([l[ord(c) - ord('a')] for c in word])
        return len({toMorse(word) for word in words})

