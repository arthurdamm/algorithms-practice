# LeetCode 421. Maximum XOR of Two Numbers in an Array
# O(n) time-and-space
class Trie:
    def __init__(self):
        self.children = {}
        self.isWord = None

    def insert(self, num: int) -> None:
        node = self
        for i in range(31, -1, -1):
            bit = num & (1 << i)
            bit = 1 if bit != 0 else 0
            if bit not in node.children:
                node.children[bit] = Trie()
            node = node.children[bit]
        node.isWord = num

class Solution:
    def findMaximumXOR(self, nums) -> int:
        trie = Trie()
        for n in nums:
            trie.insert(n)
        a = trie
        b = trie
        self.max = -1
        def traverse(a, b):
            while a.isWord is None:
                if len(a.children) == 2 and len(b.children) == 2:
                    traverse(a.children[1], b.children[0])
                    a = a.children[0]
                    b = b.children[1]
                elif len(a.children) == 2:
                    if 0 in b.children:
                        b = b.children[0]
                        a = a.children[1]
                    else:
                        b = b.children[1]
                        a = a.children[0]
                elif len(b.children) == 2:
                    if 0 in a.children:
                        b = b.children[1]
                        a = a.children[0]
                    else:
                        b = b.children[0]
                        a = a.children[1]
                else:
                    if 0 in a.children:
                        a = a.children[0]
                    else:
                        a = a.children[1]
                    if 0 in b.children:
                        b = b.children[0]
                    else:
                        b = b.children[1]
            self.max = max(self.max, a.isWord ^ b.isWord)
        traverse(a, b)
        return self.max

d = [32,18,33,42,29,20,26,36,15,46]
print("Solution", d, Solution().findMaximumXOR(d))

