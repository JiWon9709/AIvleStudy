import sys
n = int(input())
# 이중배열
time = [[0]*2 for i in range(n)]
for i in range(n):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    time[i][0] = start
    time[i][1] = end
# 끝나는 시간이 제일 빠른 순으로 정렬
time.sort(key=lambda x: (x[1], x[0]))

ee = time[0][1]
cnt = 1
for i in range(1, n):
    if ee <= time[i][0]:
        cnt += 1
        ee = time[i][1]

print(cnt)