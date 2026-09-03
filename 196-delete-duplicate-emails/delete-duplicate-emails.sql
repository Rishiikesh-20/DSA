# Write your MySQL query statement below

WITH person_copy AS (
    SELECT * FROM Person
)
DELETE FROM Person WHERE id NOT IN (SELECT min(id) FROM person_copy GROUP BY email);