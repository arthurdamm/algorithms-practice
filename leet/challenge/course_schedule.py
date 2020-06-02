#!/usr/bin/env python3
"""
Course Schedule
Solution
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
"""

from collections import defaultdict
from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        visited = defaultdict(int)
        for edge in prerequisites:
            graph[edge[0]].append(edge[1])

        def dfs(course):
            if visited[course] == 1: return
            if visited[course] == -1: return True
            visited[course] = -1
            for other in graph[course]:
                if dfs(other):
                    return True
            visited[course] = 1

        for i in range(numCourses):
            if dfs(i):
                return False
        return True

d = [[1,0],[0,1]]
print("Solution", d, Solution().canFinish(2, d))

