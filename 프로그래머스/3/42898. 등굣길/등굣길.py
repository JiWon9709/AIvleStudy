def solution(m, n, puddles):
    maps = [[0]*m for _ in range(n)]
    
    for puddle in puddles:
        maps[puddle[1]-1][puddle[0]-1] = -1
    maps[0][0] = 1
    for i in range(n):
        for j in range(m):
            if maps[i][j] == -1:
                maps[i][j] = 0
                continue
            if i == j == 0:
                continue
            if i > 0:
                maps[i][j] += maps[i-1][j]
            if j > 0:
                maps[i][j] += maps[i][j-1]
            # i-1 >= 0 일때만 maps[i-1][j]를 더할수 있고 j-1>=0 일때만 maps[i][j-1]을 더할수 있으므로 위와같은 if문
                # maps[i][j] = maps[i-1][j] + maps[i][j-1]
    return (maps[n-1][m-1]) % 1000000007