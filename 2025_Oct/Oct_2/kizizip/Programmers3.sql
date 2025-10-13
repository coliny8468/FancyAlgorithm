-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) as count
from animal_outs 
where time(datetime) between '09:00:00' and '19:59:00'
group by hour(datetime)
order by hour(datetime) asc
