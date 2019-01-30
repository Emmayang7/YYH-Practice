//Leetcode 183

SELECT Name as Customers from Customers c
where c.Id not in (
SELECT CustomerId
from Orders
);

#Others
SELECT A.Name from Customers A
WHERE NOT EXISTS (SELECT 1 FROM Orders B WHERE A.Id = B.CustomerId)

SELECT A.Name from Customers A
LEFT JOIN Orders B on  a.Id = B.CustomerId
WHERE b.CustomerId is NULL

