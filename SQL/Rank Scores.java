//Leetcode 178

# Write your MySQL query statement below
SELECT Scores.Score, COUNT(Ranking.Score) as Rank
FROM Scores,(
SELECT DISTINCT Score
FROM Scores
) Ranking
WHERE Scores.Score <= Ranking.Score
GROUP BY Scores.Id
ORDER BY Scores.Score DESC;
