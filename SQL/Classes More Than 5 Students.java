//Leetcode 596

select class from courses group by class having count(distinct student)> 4 ; #use having
