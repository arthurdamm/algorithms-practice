#!/usr/bin/env python3
"""Ternary Tree Practice by ArthurDamm@HolbertonSchool 10/18/2019"""

class Node:
    def __init__(self, char, low=None, mid=None, high=None):
        self.char = char
        self.low = low
        self.mid = mid
        self.high = high

def insert(node, key, val=None):
    if not val:
        val = key
    char = key[0] if key else 0
    if not node:
        node = Node(char)
    if num(char) < num(node.char):
        node.low = insert(node.low, key, val)
    elif num(char) > num(node.char):
        node.high = insert(node.high, key, val)
    else:
        node.mid = insert(node.mid, key[1:], val) if char else val
    return node

def search(node, key, val=None):
    if not val:
        val = key
    if not node:
        return False
    if not key:
        return node.mid == val
    if num(key[0]) < num(node.char):
        return search(node.low, key, val)
    elif num(key[0]) > num(node.char):
        return search(node.high, key, val)
    return search(node.mid, key[1:], val)

def traverse(node):
    if not node:
        return
    traverse(node.low)
    if node.char:
        traverse(node.mid)
    else:
        print("Traversed:", node.mid)
    traverse(node.high)

def nearNeighborSearch(node, key, dist):
    if not node or dist < 0:
        return
    char = key[0] if key else 0
    if dist > 0 or num(char) < num(node.char):
        nearNeighborSearch(node.low, key, dist)
    if node.char == 0:
        if len(key) <= dist:
            print("\tNear Match:", node.mid)
    else:
        nearNeighborSearch(node.mid, key[1:], dist if char == node.char else dist - 1)
    if dist > 0 or num(char) > num(node.char):
        nearNeighborSearch(node.high, key, dist)

def num(arg):
    return ord(arg) if type(arg) == str else arg

if __name__ == "__main__":
    words = ["cute", "cup", "at", "as", "he", "us", "i"]
    mispelled_words = ["cut", "cups", "a", "eh", "bus", "hi"]
    root = None
    for word in words:
        root = insert(root, word)

    traverse(root)
    for word in words:
        print("True Search: {}: {}".format(word, search(root, word)))
    for word in mispelled_words:
        print("False Search: {}: {}".format(word, search(root, word)))
    for word in mispelled_words:
        print("Near Neighbor Search: {}".format(word))
        nearNeighborSearch(root, word, 1)
