T = int(input())
# test_case = list(map(int, input().split()))

# 13
# 13 // 2 = 6 - 1
# 6 // 2 = 3  - 0
# 3 // 2 = 1 - 1
# 0 1 2 3
# 1 1 0 1
#       <
# 1 0 1 1
# stack = []
# def make_binaray_number(n):
#     if n < 2: # 탈출조건
#         stack.append(1)
#         return stack
#     stack.append(n % 2)
#     return  make_binaray_number(n // 2)

for _ in range(T):
    n = int(input())
    # print(make_binaray_number(test)) # 1 0 1 1
    # idx 0 1 2 3
    #     1 0 1 1
    #     3 2 1 0
    res = []
    idx = 0
    while n > 0:
        if n % 2 == 1:
            res.append(str(idx))
        n //= 2
        idx += 1
    print(" ".join(map(str, res)))