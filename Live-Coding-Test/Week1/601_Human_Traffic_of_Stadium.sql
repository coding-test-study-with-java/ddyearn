with t as
         (select *, id - row_number() over() as rownumber
          from stadium
          where people >= 100)

select id, visit_date, people
from t
where rownumber in (select rownumber from t group by rownumber having count(*) >= 3)
order by visit_date