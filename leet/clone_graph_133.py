#!/usr/bin/env python3
"""
133. Clone Graph

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return
        clones = {}
        queue = []
        queue.append(node)
        while len(queue):
            for _ in range(len(queue)):
                curr = queue.pop(0)
                if curr not in clones:
                    clones[curr] = Node(curr.val)
                if clones[curr].neighbors:
                    continue
                for neighbor in curr.neighbors:
                    if neighbor not in clones:
                        clones[neighbor] = Node(neighbor.val) 
                    clones[curr].neighbors.append(clones[neighbor])
                    if not clones[neighbor].neighbors:
                        queue.append(neighbor)
        return clones[node]
