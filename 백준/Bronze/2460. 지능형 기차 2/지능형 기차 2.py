max_num = 0
now_people_num = 0
for i in range(10):
    out_people_number, in_people_number = map(int, input().split())
    now_people_num += in_people_number - out_people_number
    if max_num < now_people_num:
        max_num = now_people_num
print(max_num)