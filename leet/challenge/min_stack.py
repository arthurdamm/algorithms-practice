#!/usr/bin/env python3
"""
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        self.min = None

    def push(self, x: int) -> None:
        self.arr.append(x)
        if self.min is None or x < self.min:
            self.min = x

    def pop(self) -> None:
        ret = self.arr.pop()
        if ret == self.min:
            self.min = min(self.arr) if self.arr else None
        return ret

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()