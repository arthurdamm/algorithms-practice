from typing import List

class Solution:
    def largestOverlap(self, A: List[List[int]], B: List[List[int]]) -> int:
        def rowToInt(row):
            n = 0
            for i, r in enumerate(row):
                if r:
                    n |= 1 << len(row) - (i + 1)
            return n
        
        def numBits(num):
            total = 0
            for i in range(len(A)):
                print("C", i, (1 << i), num)
                if (1 << i) & num:
                    total += 1
            return total
                    
        A = [rowToInt(row) for row in A]
        B = [rowToInt(row) for row in B]
        print("RTI", A, B)
        print("NUMBITS", numBits(7))
        _max = float('-inf')        
        for downshift in range(len(A)):
            for rightshift in range(len(A)):
                total = 0
                for i in range(len(A)):
                    if i + downshift < len(A):
                        total += numBits((A[i] >> rightshift) & B[i + downshift])
                _max = max(_max, total)
        for downshift in range(len(A)):
            for rightshift in range(len(A)):
                total = 0
                for i in range(len(A)):
                    if i + downshift < len(A):
                        total += numBits((B[i] >> rightshift) & A[i + downshift])
                _max = max(_max, total)
        return _max

A = [[1]]
B = [[1]]
print("Solution to", A, B, Solution().largestOverlap(A, B))
A = [[1, 1, 1], [0, 0, 0], [0, 0, 0]]
B = [[0, 0, 0], [1, 1, 1], [0, 0, 0]]
print("Solution to", A, B, Solution().largestOverlap(A, B))
