h, w = map(int, input().split())
# block = [[0] * w for _ in range(h)]
# heights = list(map(int, input().split()))
block = list(map(int, input().split()))
# 4 * 4
# [3, 0, 1, 4]
# for i in range(len(heights)):
#     block_height = heights[i] # 3, i =0
#     for j in range(block_height):
#         block[j][i] = 1
# print(block)
# 0 0 0 1
# 1 0 0 1
# 1 0 0 1
# 1 0 1 1

# 빗물 고이는 경우: 같은 층에서 양 옆이 1일때가 최대층
# 즉, 각 층마다 양옆이 1을 만날때까지 +1
# 가장 낮은층의 0부터 시작, bfs
# stack = []
# start_block = 가장낮은층의 0부터 시작
# def find_block(): # bfs
#     start_block, end_block = 같은행의 양옆이 1인 블럭
#     end_block 이 나오기전까지 빗물양 +1
    # return 0

# 현재블록, left, right 블록의 차이를 구하며 더해가는 방식
# 양옆의 블록은 제외하고 한칸씩 옮겨가며 빗물블록개수세어서 answer에 더해감
# 현재 블록이 가는 범위: 1부터 끝에서 한칸 아래까지
# left 포인터는 왼쪽부터 블럭의 현재 위치까지 중 가장 높은 블럭의 층을 저장
# right : 현재블록의 한칸 옆부터 오른쪽 블럭의 끝까지 중 가장 높은 블럭의 층을 저장
# m은 left와 right 블럭 중 가장 낮은 블럭을 찾음. 왜냐하면 빗물은 가장 낮은층까지만 채워짐
# 만약 현재 블록의 개수가 m 보다 작다면 즉, 빗물을 채울수있는 높이라면 answer에 빗물을 채울수있는 높이 - 현재 블록높이를 더해준다
# 현재 블럭이 더 높으면 다음 블럭으로 이동
answer = 0
for i in range(1, w-1):
    left = max(block[:i])
    right = max(block[i+1:])
    m = min(left, right)
    if m > block[i]:
        answer += m - block[i]
print(answer)
