-- 코드를 입력하세요
SELECT a.product_code, sum(a.price * b.sales_amount) as sales
from product a
join offline_sale b on b.product_id = a.product_id
group by product_code
order by sum(a.price * b.sales_amount) desc, product_code asc
