-- 코드를 입력하세요
select date_format(a.sales_date, '%Y-%m-%d') AS SALES_DATE
, product_id, user_id, sales_amount
    from 
    (SELECT SALES_DATE, product_id, user_id, sales_amount
    from online_sale
    union all
    select SALES_DATE, product_id, NULL as user_id, sales_amount 
    from offline_sale) a
where sales_date like '2022-03%'
order by SALES_DATE, product_id, user_id