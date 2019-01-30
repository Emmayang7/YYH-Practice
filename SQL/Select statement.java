//Hacker Rank

SELECT * FROM CITY;
SELECT * FROM CITY WHERE ID = 1661;
SELECT * FROM CITY WHERE COUNTRYCODE = "JPN";
SELECT NAME FROM CITY WHERE COUNTRYCODE = "JPN";
SELECT CITY, STATE FROM STATION;
SELECT COUNT(CITY) - COUNT(DISTINCT CITY) FROM STATION;
select name from Employee order by name asc;
select name from Employee where salary > 2000 and months < 10;
select ROUND(SUM(LAT_N),4) from STATION where LAT_N > 38.7880 and LAT_N < 137.2345;
select ROUND(MAX(LAT_N),4) from STATION where LAT_N < 137.2345;
select ROUND(MIN(LAT_N),4) from STATION where LAT_N > 38.7780;
select ROUND(Long_W, 4) from STATION where LAT_N = (Select MIN(LAT_N) from STATION where LAT_N > 38.7780 );
select round(LONG_W,4) from STATION where LAT_N>38.7780 order by LAT_N limit 1;
select round(ABS(MAX(LAT_N) - MIN(LAT_N)) + ABS(MAX(LONG_W) - MIN(LONG_W)),4) from STATION;
select round(SQRT( pow(ABS(MAX(LAT_N) - MIN(LAT_N)),2) + pow(ABS(MAX(LONG_W) - MIN(LONG_W)),2)),4) from STATION;
SELECT AVG(Population) from City where District = "California";
SELECT Round(AVG(Population)) FROM CITY;
SELECT SUM(Population) FROM CITY WHERE CountryCode = "JPN";
SELECT MAX(Population) - MIN(Population) FROM city;

MOD!!!! Weather Observation Station 3
SELECT DISTINCT CITY FROM STATION WHERE ID mod 2 = 0; #MOD(5,3), 5 % 3, 5 MOD 3

Length of an string, MIN MAX result!!!! attribute Weather Observation Station 5
SELECT DISTINCT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY), CITY ASC LIMIT 1;
SELECT DISTINCT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY) DESC, CITY ASC LIMIT 1;
Result:
Amo 3
Marine On Saint Croix 21

first char in string!!!! Weather Observation Station 6
SELECT distinct city FROM STATION where lower(substr(city, 1, 1)) in ('a','e','i','o','u');
Result:
Acme
Addison
Agency
....
#starting and ending with vowels (a, e, i, o, u)
SELECT distinct city FROM STATION where lower(substr(city, length(city), 1)) in ('a','e','i','o','u') and lower(substr(city, 1, 1)) in ('a','e','i','o','u');

SELECT city, lower(substr(CITY,1,2)), lower(substr(CITY,2,1)) FROM STATION;
Result:
Kissee Mills ki i
Loma Mar lo o

Order your output by the last three characters of each name!!!Higher Than 75 Marks
#If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID
select Name from students where Marks > 75
Order by substr(Name, length(Name)-2, 1), substr(Name, length(Name)-1, 1), substr(Name, length(Name), 1), ID asc;

Replace, Ceil, Floor, Round on integer!!! The Blunder
select CEIL(AVG(Salary) - AVG(REPLACE(Salary, '0',''))) from EMPLOYEES;
ceil （） /ceiling（） 向上取整
eg： ceil（1.2） = 2
floor （） 向下取整
eg： floor（1.2） = 1
round（） 四舍五入

aggregation GROUP BY USAGE!!!! Top Earners
select months * salary as earning, count(months * salary)
from Employee
group by months * salary
order by earning DESC limit 1;

2 decimal places!!!! Weather Observation Station 2
select round(SUM(LAT_N),2), round(SUM(LONG_W),2) from station;

subquery where!!!!Weather Observation Station 15
select ROUND(LONG_W,4) from STATION where LAT_N = (SELECT MAX(LAT_N) FROM STATION WHERE LAT_N < 137.2345);

Median!!!Weather Observation Station 20
select round(LAT_N, 4) from STATION S where
(select count(LAT_N) from station where Lat_N < S.LAT_N) = (select count(LAT_N) from station where Lat_N > S.LAT_N);

OUTPUT new Value from if statement on original column!!!!***** Type of Triangle
SELECT CASE
WHEN A + B > C AND A + C > B AND B + C > A
THEN CASE WHEN A = B AND B = C THEN "Equilateral"
WHEN A = B or B = C or A = C THEN "Isosceles"
ELSE "Scalene" END
ELSE "Not A Triangle" END
FROM TRIANGLES;

SELECT CASE WHEN A + B <= C OR A + C <= B OR B + C <= A THEN 'Not A Triangle' WHEN A=B AND B=C THEN 'Equilateral' WHEN A=B OR A=C OR B=C THEN 'Isosceles' ELSE 'Scalene' END FROM TRIANGLES;

SELECT CASE WHEN A + B > C AND A+C>B AND B+C>A THEN CASE WHEN A = B AND B = C THEN 'Equilateral' WHEN A = B OR B = C OR A = C THEN 'Isosceles' WHEN A != B OR B != C OR A != C THEN 'Scalene' END ELSE 'Not A Triangle' END FROM TRIANGLES;

Basic Join!!!!***** Challenges
select h.hacker_id, h.name, count(c.challenge_id) as C_count from Hackers as h
inner join
Challenges as c on h.hacker_id = c.hacker_id group by c.hacker_id, h.name
having
C_count = (Select max(temp1.max_num) from
(select count(challenge_id) as max_num from Challenges group by hacker_id) temp1)
or
C_count in (select temp2.c_num from
(select count(challenge_id) as c_num from Challenges group by hacker_id) temp2
group by temp2.c_num
having count(temp2.c_num) = 1)

order by C_count DESC, h.hacker_id;

Inner Join!!!!***** Contest Leaderboard
select h.hacker_id, h.name, sum(max_score) as total_score
from Hackers h inner join
(select max(score) as max_score, hacker_id  from Submissions group by hacker_id, challenge_id) temp1
on h.hacker_id = temp1.hacker_id
group by h.hacker_id, h.name
having total_score >0
order by total_score DESC, h.hacker_id
;



////SELECT N, IF(P IS NULL,'Root',IF((SELECT COUNT(*) FROM BST WHERE P=B.N)>0,'Inner','Leaf')) FROM BST AS B ORDER BY N;






