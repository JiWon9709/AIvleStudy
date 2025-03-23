n = int(input())
arr = list(map(int, input().split()))
operators = list(map(int, input().split()))

# 초기값을 반대로 잡았기 때문에 최대최소가 제대로 안나옴.
# 초기값 설정 주의
max_res, min_res = -1e9, 1e9

# 3 4 5
# + *
# 2

# 1 2 3 4 5 6
# + + - * /
# + - + * /
# - + + * /
# 5 * 4 * 3* 2 * 1
# 같은 연산자 일때는 어떻게 바꾸면 좋을까...?
# 20분 고민하다가 찾아보니까 백트레킹, dfs(재귀함수), 순열로 문풀
def dfs(depth, total):
    global max_res, min_res
    if depth == n:
        max_res = max(total, max_res)
        min_res = min(total, min_res)
        return

    if operators[0]: # 덧셈 연산자가 남아 있다면
        operators[0] -= 1 # 연산자를 사용
        dfs(depth + 1, total + arr[depth]) # 다른 숫자로 진행
        operators[0] += 1 # 연산자 복구 (원래 상태로 되돌리기)
        # 모든 연산 조합을 탐색하기 위해
    if operators[1]:
        operators[1] -= 1
        dfs(depth+1, total - arr[depth])
        operators[1] += 1
    if operators[2]:
        operators[2] -= 1
        dfs(depth+1, total * arr[depth])
        operators[2] += 1
    if operators[3]:
        operators[3] -= 1
        dfs(depth+1, int(total/arr[depth]))
        operators[3] += 1

dfs(1, arr[0])
print(max_res)
print(min_res)