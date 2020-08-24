#!/usr/bin/env python3
# LeetCode 690. Employee Importance

"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class BFSSolution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        emps = {}
        for employee in employees:
            emps[employee.id] = employee
        queue = []
        total_importance = 0
        queue.append(id)
        while len(queue):
            for _ in queue:
                employee = queue.pop(0)
                total_importance += emps[employee].importance
                for subordinate in emps[employee].subordinates:
                    queue.append(subordinate)
        return total_importance

class DFSSolution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        emps = {}
        for employee in employees:
            emps[employee.id] = employee
        def dfs(id):
            total_importance = emps[id].importance
            for employee in emps[id].subordinates:
                total_importance += dfs(employee)
            return total_importance
        return dfs(id)
