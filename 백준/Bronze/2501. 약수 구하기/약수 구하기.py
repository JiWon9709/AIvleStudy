n, k = map(int, input().split())
res = [] # 1은 무조건 약수임

for i in range(1, n+1): # 1과 자기자신은 약수임.
    if n % i == 0: # n을 i로 나눴을때 0으로 떨어지면, 약수
        res.append(i)
    if len(res) == k: # k개 일 경우 탈출
        print(res[k-1])
        break
    # print(res)
else:
    if n == k == 1:
        print(1)
    else:
        print(0)
