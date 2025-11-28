SELECT u.USER_ID, u.NICKNAME, b.TOTAL_SALES from USED_GOODS_USER u
join (select WRITER_ID, SUM(PRICE) as TOTAL_SALES from USED_GOODS_BOARD
      where STATUS = "DONE"
      group by WRITER_ID
      having SUM(PRICE)>= 700000
) b on b.WRITER_ID = u.USER_ID
order by b.TOTAL_SALES;
