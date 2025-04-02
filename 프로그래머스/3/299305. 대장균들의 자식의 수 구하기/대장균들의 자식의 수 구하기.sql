-- 코드를 작성해주세요
select e1.id, count(e2.parent_id) as child_count
from ecoli_data e1
left join ecoli_data e2 on e1.id = e2.parent_id
group by e1.id
order by e1.id

# 그룹화 한후 모든 열에 대해 보고싶을때 서브쿼리 join
# SELECT 
#   e.*,
#   g.child_count
# FROM ecoli_data e
# LEFT JOIN (
#     SELECT parent_id, COUNT(*) AS child_count
#     FROM ecoli_data
#     GROUP BY parent_id
# ) g ON e.id = g.parent_id;

