n, m = map(int, input().split())
current_r, current_c, current_d = map(int, input().split())
current_room_map = []
for _ in range(n):
    current_room_map.append(list(map(int, input().split())))
# current_room_map = [
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 1, 1, 1, 1, 0, 1],
#     [1, 0, 0, 1, 1, 0, 0, 0, 0, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
# ]
# 2, 3
# r , c
# (n-c, r)
from collections import deque
# n * m
def get_d_rotate(d):
    return (d+3) % 4
def get_d_back(d):
    return (d+2) % 4
def get_count_of_departments_cleaned_by_robot_vacuum(r, c, d, room_map):
    n, m = len(room_map), len(room_map[0])
    queue = deque()
    queue.append((r, c, d))
    # 0, 1, 2, 3
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    cnt = 1
    visited = list([0]* m for _ in range(n))
    visited[r][c] = 1
    while queue:
        r, c, d = queue.popleft()
        # print(r, c, d)
        for i in range(4):
            d = get_d_rotate(d)
            x, y = r + dr[d], c + dc[d]
            if 0<= x<n and 0<= y < m and room_map[x][y] == 0 and visited[x][y] == 0:
                visited[x][y] = 1
                cnt += 1
                queue.append((x, y, d))
                break
            elif i == 3:
                x, y = r+ dr[get_d_back(d)], c + dc[get_d_back(d)]
                queue.append((x, y, d))
                if room_map[x][y] == 1:
                    return cnt


# 57 가 출력되어야 합니다!
print(get_count_of_departments_cleaned_by_robot_vacuum(current_r, current_c, current_d, current_room_map))
# current_room_map2 = [
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 1, 1, 1, 1, 0, 1],
#     [1, 0, 0, 1, 1, 0, 0, 0, 0, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
# ]
# print("정답 = 29 / 현재 풀이 값 = ", get_count_of_departments_cleaned_by_robot_vacuum(6,3,1,current_room_map2))
# current_room_map3 = [
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 1, 1, 1, 1, 0, 1],
#     [1, 0, 0, 1, 1, 0, 0, 0, 0, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 1, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
# ]
# print("정답 = 33 / 현재 풀이 값 = ", get_count_of_departments_cleaned_by_robot_vacuum(7,4,1,current_room_map3))
# current_room_map4 = [
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 1, 0, 1, 1, 1, 1, 0, 1],
#     [1, 0, 0, 1, 1, 0, 0, 0, 0, 1],
#     [1, 0, 1, 1, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 1, 0, 0, 1, 1, 0, 1],
#     [1, 0, 0, 0, 0, 0, 0, 0, 0, 1],
#     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
# ]
# print("정답 = 25 / 현재 풀이 값 = ", get_count_of_departments_cleaned_by_robot_vacuum(6,2,0,current_room_map4))