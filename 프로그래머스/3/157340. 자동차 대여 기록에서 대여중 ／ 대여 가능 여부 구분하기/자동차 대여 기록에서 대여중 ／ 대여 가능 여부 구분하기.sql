-- 코드를 입력하세요
SELECT A.CAR_ID, CASE WHEN B.CAR_ID IS NOT NULL THEN '대여중'
ELSE '대여 가능' END AS AVAILABILITY
FROM (
    SELECT DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) A LEFT JOIN
    (SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE) B
    ON A.CAR_ID = B.CAR_ID
GROUP BY A.CAR_ID
ORDER BY A.CAR_ID DESC;