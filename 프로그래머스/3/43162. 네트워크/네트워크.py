from collections import deque
def solution(n, computers):
    answer = 0
    map = [False] * n
    #   0 1 2
    # 0 1 1 0
    # 1 1 1 0
    # 2 0 0 1
    # 자기자신은 빼고 if 1 인경우 > [0][1]
    for j in range(n):
        if map[j] == False:
            q = deque([j])
            while q:
                # print(q)
                x = q.popleft()
                map[x] = True
                for i in range(n):
                    if i == x:
                        continue
                    if computers[x][i] == 1 and not map[i]:
                        q.append(i)
            answer += 1
            # print(map)
    return answer