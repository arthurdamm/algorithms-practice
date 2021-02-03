# LeetCode 182. Duplicate Emails
# https://leetcode.com/problems/duplicate-emails/
SELECT DISTINCT a.email
FROM Person a
JOIN Person b
ON a.email = b.email
WHERE a.id != b.id;

#
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;

# 