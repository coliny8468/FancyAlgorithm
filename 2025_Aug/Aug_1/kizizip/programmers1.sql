SELECT NAME, count(*) as COUNT
from ANIMAL_INS
where name is not null 
GROUP BY NAME
having COUNT >= 2
ORDER BY NAME;
