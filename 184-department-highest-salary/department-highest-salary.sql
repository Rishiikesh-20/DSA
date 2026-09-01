# Write your MySQL query statement below


SELECT d.name AS Department , e.name as Employee , e.salary FROM (
    SELECT id,name,salary,departmentId,DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rn FROM Employee
) e JOIN department d ON e.departmentId=d.id WHERE e.rn=1;