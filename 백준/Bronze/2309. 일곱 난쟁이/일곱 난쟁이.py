nan_heights = []
for _ in range(9):
    nan_heights.append(int(input()))
# 7명의 합이 100이 되는걸 찾기
# 우선 정렬을 해서 9명의 키를 다 합쳐보기
nan_heights.sort()
diff_height = sum(nan_heights) - 100
is_find = False
# 9명키의 합(140)에서 100을 빼서 2개의 수의 합이 (140-100) 이 되도록 만들기
for i in range(9):
    for j in range(9):
        if j != i and nan_heights[i] + nan_heights[j] == diff_height:
            # 찾으면 그 두 수를 빼고 출력
            for k in range(9):
                if k != i and k != j:
                    print(nan_heights[k])
            is_find = True
            break
    if is_find:
        break