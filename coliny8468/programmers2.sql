select d.DEPT_ID, d.DEPT_NAME_EN, ROUND(e.AVG_SAL, 0) AS AVG_SAL from HR_DEPARTMENT d
join (select DEPT_ID, avg(SAL * 1.0) AS AVG_SAL
      from HR_EMPLOYEES 
      group by DEPT_ID) e on d.DEPT_ID = e.DEPT_ID
      order by e.AVG_SAL desc;
