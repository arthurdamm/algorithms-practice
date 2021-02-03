# LeetCode 197. Rising Temperature
# https://leetcode.com/problems/rising-temperature/
SELECT w2.id
FROM Weather w1 JOIN Weather w2
ON w1.recordDate = DATE_SUB(w2.recordDate, INTERVAL 1 DAY)
WHERE w1.temperature < w2.temperature;

#
SELECT w1.id
FROM Weather w1 JOIN Weather w2
ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
AND w1.temperature > w2.temperature;
