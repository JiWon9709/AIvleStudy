-- 코드를 입력하세요
SELECT FLAVOR
from FIRST_HALF
where TOTAL_ORDER > 3000 and FLAVOR in(select FLAVOR
                                    FROM ICECREAM_INFO
                                    WHERE INGREDIENT_TYPE = 'fruit_based')
order by total_order desc;