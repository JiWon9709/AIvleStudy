def solution(array):
    answer = []
    cnt = []
    # 1 2 3 3 3 4
    # (1, 1)
    # (2, 1)
    # (3, 1)
    # (3, 2)
    # (3, 3)
    for i in range(len(array)):
        if array[i] not in answer:
            answer.append([array[i], 1])
        else:
            answer[array[i]][1] += 1
    idx = max(answer[1])
    return answer