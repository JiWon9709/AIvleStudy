a, b = map(int, input().split())

sum = 0
# 1223334444
#   3   7

idx = 1
arr = []
def find_num(idx, arr):
    i = 1
    add_i = i
    while add_i <= idx:
        for _ in range(i):
            arr.append(i)
            add_i += 1
        i += 1
    return arr[idx-1]

find_num(b, arr)
sum = 0
for i in range(a-1, b):
    sum += arr[i]
print(sum)