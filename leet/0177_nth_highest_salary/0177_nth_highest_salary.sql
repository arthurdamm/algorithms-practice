# LeetCode 177. Nth Highest Salary
# https://leetcode.com/problems/nth-highest-salary/
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      SELECT DISTINCT salary from Employee ORDER BY salary DESC LIMIT N, 1
     
  );
END
