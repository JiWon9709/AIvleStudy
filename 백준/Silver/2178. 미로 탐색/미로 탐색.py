# 2178
import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
miro = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n):
    if n > 0 and m > 0:
        miro.append([0] * m)

for i in range(n):
    line = list(map(int, sys.stdin.readline().rstrip()))
    for j in range(m):
        miro[i][j] = line[j]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and ny >= 0 and nx < n and ny < m:
                if miro[nx][ny] == 1:
                    queue.append((nx, ny))
                    miro[nx][ny] = miro[x][y] + 1
    return miro[n-1][m-1]

print(bfs(0, 0))