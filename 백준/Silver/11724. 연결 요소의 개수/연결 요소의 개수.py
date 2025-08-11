# dfs / visited 방문처리 그래프 만들기
n, m = map(int, input().split())
graph = [[] for i in range(n+1)]
visited = [False] * (n + 1)

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
connect = 0

def dfs(v):
    # 1. 방문처리
    visited[v] = True
    # 2. graph 에서 연결된 노드에 방문 하지않았다면 dfs
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

# 모든 노드들에 대해 방문 하지 않았다면 dfs 후 연결 +1
for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        connect += 1

print(connect)

