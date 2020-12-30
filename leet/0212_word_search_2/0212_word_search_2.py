# LeetCode 212. Word Search II
# https://leetcode.com/problems/word-search-ii/
# O(k*m*n) time O(k*w) space, k average word length, w words
class Trie:
    def __init__(self):
        self.word=None
        self.children=defaultdict(Trie)
    def insert(self,word):
        node = self
        for c in word:
            node = node.children[c]    
        node.word = word
        
    def delete (self, node, word, i):
        if i == len(word):
            if node.word == word:
                node.word = None
            if not node.children:
                return True
            return False
        if word[i] not in node.children:
            return False
        if self.delete(node.children[word[i]], word, i + 1):
            del node.children[word[i]]
            if not node.children:
                return True
        return False
        
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        ans = set()
        def backtrack(i,j,node):
            c=board[i][j]
            if c not in node.children:
                return
            if node.children[c].word != None:
                ans.add(node.children[c].word)
                root.delete(root, node.children[c].word, 0)
            
            board[i][j] = '*'
            if i>0:
                backtrack(i-1,j,node.children[c])
            if j>0:
                backtrack(i,j-1,node.children[c])
            if i<len(board)-1:
                backtrack(i+1,j,node.children[c])
            if j<len(board[i])-1:
                backtrack(i,j+1,node.children[c])
            board[i][j] = c
    
        root = Trie()
        for word in words:
            root.insert(word)
        for i in range(len(board)):
            for j in range(len(board[i])):
                backtrack(i,j,root)
        return list(ans)
