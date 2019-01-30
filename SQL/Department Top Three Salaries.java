//Leetcode 185
# Write your MySQ
L query statement below
select d.Name as Department, e.Name as Employee, e.Salary as Salary from Employee e inner join Department d on e.DepartmentId = d.Id
where 3 > (Select count(Distinct e2.Salary) from Employee e2
where e2.DepartmentId=e.DepartmentId and
e2.Salary > e.Salary);

#Others
SELECT D.Name as Department, E.Name as Employee, E.Salary
FROM Department D, Employee E, Employee E2
WHERE D.ID = E.DepartmentId and E.DepartmentId = E2.DepartmentId and
E.Salary <= E2.Salary
group by D.ID,E.Name having count(distinct E2.Salary) <= 3
order by D.Name, E.Salary desc
