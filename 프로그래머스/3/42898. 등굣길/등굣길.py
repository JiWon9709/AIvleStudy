from collections import deque
def solution(m, n, puddles):
    q = deque([[0, 0]])
    maps = [[0]*m for _ in range(n)]
    # visited = [[False]*m for _ in range(n)]
    # visited[0][0] = True
    for puddle in puddles:
        maps[puddle[1]-1][puddle[0]-1] = -1
    maps[0][0] = 1
    for i in range(n):
        for j in range(m):
            if maps[i][j] == -1:
                maps[i][j] = 0
                continue
            if i > 0:
                maps[i][j] += maps[i-1][j]
            if j > 0:
                maps[i][j] += maps[i][j-1]
            # maps[i][j] = maps[i-1][j] + maps[i][j-1]
    # print(maps)
    return (maps[n-1][m-1]) % 1000000007