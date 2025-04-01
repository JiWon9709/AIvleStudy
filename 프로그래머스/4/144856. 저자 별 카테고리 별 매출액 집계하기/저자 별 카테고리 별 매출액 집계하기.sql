-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(s.sales * b.price) as total_sales
from book b 
join (select book_id, sales
                    from book_sales
                    where sales_date like '2022-01%'
                   ) as s
                   on b.book_id = s.book_id
join author a on a.author_id = b.author_id
group by author_id, category
order by author_id, category desc