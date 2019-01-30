//Leetcode 177

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
RETURN (
# Write your MySQL query statement below.
/*select distinct Salary from Employee
 order by Salary desc limit 1 offset N */
/*SELECT DISTINCT Salary
 FROM Employee a
 WHERE ((SELECT COUNT(*)
 FROM (SELECT DISTINCT Salary FROM Employee) b
 WHERE (b.Salary > a.Salary)) = N - 1)
 
 SELECT DISTINCT main.Salary
 FROM Employee main
 WHERE ((SELECT COUNT(*)
 FROM (SELECT DISTINCT Salary
 FROM Employee) Sub
 WHERE (main.Salary <= Sub.Salary)) = N)*/

);
END
