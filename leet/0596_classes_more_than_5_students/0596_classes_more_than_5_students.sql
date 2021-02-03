# LeetCode 596. Classes More Than 5 Students
# https://leetcode.com/problems/classes-more-than-5-students/
SELECT class FROM
(
    SELECT class, count(*) c
    FROM
    (
        SELECT DISTINCT student, class FROM courses
    ) t1
    GROUP BY class
) t2
WHERE c >= 5;

#
SELECT class FROM
(
    SELECT class, count(DISTINCT student) c
    FROM courses
    GROUP BY class
) t2
WHERE c >= 5;

#
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
