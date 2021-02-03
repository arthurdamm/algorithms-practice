# LeetCode 196. Delete Duplicate Emails
# https://leetcode.com/problems/delete-duplicate-emails/
DELETE FROM Person WHERE id NOT IN
(
    SELECT * FROM
    (
        SELECT MIN(id)
        FROM Person
        GROUP BY email
    ) AS t1
);

#
DELETE p1 FROM Person p1, Person p2
WHERE p1.email = p2.email
AND p1.id > p2.id;

#
WITH toDelete as
(
    SELECT p1.id FROM Person p1
    JOIN Person p2 ON p1.email = p2.email
    AND p1.id > p2.id
)
DELETE FROM Person
WHERE id IN (SELECT * FROM toDelete);
