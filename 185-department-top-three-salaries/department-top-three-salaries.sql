# Write your MySQL query statement below

SELECT d.name AS Department,e.name AS Employee,e.salary AS Salary FROM (SELECT *,DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rank_num FROM Employee) e JOIN Department d ON e.departmentId=d.id WHERE rank_num<4;