# LeetCode 181. Employees Earning More Than Their Managers
# https://leetcode.com/problems/employees-earning-more-than-their-managers/
SELECT a.name AS "Employee"
FROM Employee a
JOIN Employee b
ON a.ManagerId = b.Id
WHERE a.Salary > b.Salary;
