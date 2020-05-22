#!/usr/bin/env python3
"""
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

 Example 1:

 Input: matrix =
 [
   [0,1,1,1],
     [1,1,1,1],
       [0,1,1,1]
       ]
       Output: 15
       Explanation: 
       There are 10 squares of side 1.
       There are 4 squares of side 2.
       There is  1 square of side 3.
       Total number of squares = 10 + 4 + 1 = 15
"""
class Solution:
    def countSquares(self, matrix) -> int:
        count = 0
        for row in range(len(matrix)):
            for col in range(len(matrix[row])):
                if matrix[row][col] != 1:
                    continue
                if not row or not col:
                    count += 1
                else:
                    matrix[row][col] = min(matrix[row - 1][col - 1],
                                           matrix[row][col - 1],
                                           matrix[row - 1][col]) + matrix[row][col]
                    count += matrix[row][col]
        return count

d = [
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]

print("Solution", d, Solution().countSquares(d))
