#!/usr/bin/env python3
# LeetCode 79 Word Search

from typing import List

class Solution:
    board = None
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not word: return False
        self.board = board
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == word[0]:
                    if self.dfs(i, j, word, 0):
                        return True
                    
        return False
    
    def dfs(self, i, j, word, index):
        if index == len(word):
            return True
        if i < 0 or i >= len(self.board) or j < 0 or j >= len(self.board[i]) or\
        self.board[i][j] != word[index]:
            return False
        
        temp = self.board[i][j]
        self.board[i][j] = None;
        result =  self.dfs(i-1, j, word, index + 1) or\
        self.dfs(i+1, j, word, index + 1) or\
        self.dfs(i, j-1, word, index + 1) or\
        self.dfs(i, j+1, word, index + 1)
        self.board[i][j] = temp
        return result

if __name__ == "__main__":
    d = [["a","b"],["c","d"]]
    w = "cdba"
    print("exist()", d, w, Solution().exist(d, w))
    d = [["A","B","C","E"],
         ["S","F","E","S"],
         ["A","D","E","E"]]
    w = "ABCESEEEFS"
    print("exist()", d, w, Solution().exist(d, w))

