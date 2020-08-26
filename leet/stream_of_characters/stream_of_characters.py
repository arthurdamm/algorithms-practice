#!/usr/bin/env python3
# LeetCode 1032. Stream of Characters

from collections import deque, defaultdict

class TreeNode:
    def __init__(self):
        self.children = defaultdict(TreeNode)
        self.value = None
    def insert(self, string):
        root = self
        for char in string:
            root = root.children[char]
        root.value = string
                 
class StreamChecker:
    def __init__(self, words):
        self.root = TreeNode()
        self.characters = deque()
        for word in words:
            self.root.insert(word[::-1])
    def query(self, letter: str) -> bool:
        self.characters.appendleft(letter)
        node = self.root
        for char in self.characters:
            if char in node.children:
                node = node.children[char]
                if node.value:
                    return True
            else:
                return False

words = ["abaa","abaab","aabbb","bab","ab"]
obj = StreamChecker(words)
for letter in [["a"],["a"],["b"]]:
    print("Letter", letter[0], obj.query(letter[0]))
