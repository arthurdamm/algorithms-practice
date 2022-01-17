# LeetCode 1939. Users That Actively Request Confirmation Messages
# https://leetcode.com/problems/users-that-actively-request-confirmation-messages/
SELECT DISTINCT a.user_id FROM
Confirmations a JOIN Confirmations b
ON a.user_id = b.user_id AND a.time_stamp < b.time_stamp
WHERE TIMESTAMPDIFF(SECOND, a.time_stamp, b.time_stamp) <= 86400;
