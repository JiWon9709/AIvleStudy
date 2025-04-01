-- 코드를 입력하세요
# SELECT h.car_id, round(avg(diff), 1) as average_duration
# from (select distinct car_id
#       from car_rental_company_rental_history) h
# join (select car_id, 
#      from car_rental_company_rental_history
#      group by car_id) d
#      on h.car_id = d.car_id
# where d.average_duration >= 7
# order by d.average_duration desc, h.car_id desc


select car_id, round(avg(datediff(end_date, start_date) + 1), 1) as average_duration
    from car_rental_company_rental_history
group by car_id
having average_duration >= 7
order by average_duration desc, car_id desc