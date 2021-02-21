# LeetCode 178. Rank Scores
# https://leetcode.com/problems/rank-scores/
SELECT Score, dense_rank() OVER (ORDER BY Score DESC) `Rank` FROM Scores;

# Using rank()
WITH S1 as (SELECT DISTINCT Score from Scores),
S2 as (SELECT Score, rank() OVER (ORDER BY SCORE DESC) `Rank` FROM S1)
SELECT Scores.Score, `Rank` FROM Scores
LEFT JOIN S2 ON Scores.Score = S2.Score
ORDER BY Score DESC;