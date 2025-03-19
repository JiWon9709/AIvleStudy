m = int(input())
n = int(input())
def find_prime(x):
    if x == 1:
        return False
    if x == 2:
        return True
    i = 2
    while i < x:
        if x % i == 0:
            return False
            break
        i += 1
    return True

arr = []
sum = 0
for i in range(m, n+1):
    if find_prime(i):
        arr.append(i)
        sum += i
if len(arr) > 0:
    print(sum)
    print(arr[0])
else:
    print(-1)