# LeetCode 176. Second Highest Salary
# https://leetcode.com/problems/second-highest-salary/
SELECT IFNULL(
    (SELECT DISTINCT salary
     FROM Employee
     ORDER BY salary DESC
     LIMIT 1 OFFSET 1),
    NULL) AS 'SecondHighestSalary';
