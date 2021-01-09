# LeetCode 127. Word Ladder
# https://leetcode.com/problems/word-ladder/
# O(M^2*N) time and space
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        self.words = set(wordList)
        if endWord not in self.words:
            return 0
        queue = deque([beginWord])
        steps = 2
        while queue:
            for _ in range(len(queue)):
                for neighbor in self.findNeighbors(queue.popleft()):
                    if neighbor == endWord:
                        return steps
                    queue.append(neighbor)
            steps += 1
        return 0
    
    def findNeighbors(self, word):
        chars = list(word)
        neighbors = []
        for i in range(len(word)):
            temp = chars[i]
            for c in string.ascii_lowercase:
                chars[i] = c
                newWord = "".join(chars)
                if newWord in self.words:
                    neighbors.append(newWord)
                    self.words.remove(newWord)
            chars[i] = temp
        return neighbors    

# O(M^2*N) time and space
class SolutionB:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        self.words = set(wordList)
        if endWord not in self.words:
            return 0
        self.words.remove(endWord)
        beginSet = set([beginWord])
        endSet = set([endWord])
        steps = 1
        while beginSet and endSet:
            if len(beginSet) > len(endSet):
                temp = endSet
                endSet = beginSet
                beginSet = temp
            newSet = set()
            for word in beginSet:
                if word in endSet:
                    return steps
                newSet.update(self.findNeighbors(word, endSet))
            beginSet = newSet
            steps += 1
        return 0
    
    def findNeighbors(self, word, endSet):
        chars = list(word)
        neighbors = []
        for i in range(len(word)):
            temp = chars[i]
            for c in string.ascii_lowercase:
                chars[i] = c
                newWord = "".join(chars)
                if newWord in self.words:
                    neighbors.append(newWord)
                    self.words.remove(newWord)
                if newWord in endSet:
                    neighbors.append(newWord)
            chars[i] = temp
        return neighbors    
