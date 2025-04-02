from collections import deque
def solution(maps):
    answer = 1
    n, m = len(maps), len(maps[0])
    q = deque()
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q.append((0, 0))
    visited = [[0] * m for _ in range(n)]
    visited[0][0] = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            cur_x, cur_y = x + dx[i], y + dy[i]
            if 0 <= cur_x < n and 0 <= cur_y < m:
                if cur_x == n-1 and cur_y == m-1:
                    visited[cur_x][cur_y] = 1 + visited[x][y]
                    # print(visited)
                    return visited[cur_x][cur_y]
                if maps[cur_x][cur_y] == 1 and visited[cur_x][cur_y] == 0:
                    answer += 1
                    visited[cur_x][cur_y] = 1 + visited[x][y]
                    q.append((cur_x, cur_y))
    if visited[n-1][m-1] == 0:
        return -1
    else:
        return answer