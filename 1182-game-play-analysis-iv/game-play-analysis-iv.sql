# Write your MySQL query statement below

SELECT ROUND(COUNT(*)/(SELECT COUNT(DISTINCT player_id) FROM Activity),2) AS fraction FROM Activity a JOIN (SELECT player_id,MIN(event_date) AS event_date FROM Activity GROUP BY player_id) AS f ON a.player_id=f.player_id AND a.event_date=f.event_date JOIN Activity b ON a.player_id=b.player_id AND DATE_ADD(a.event_date, INTERVAL 1 DAY)=b.event_date;