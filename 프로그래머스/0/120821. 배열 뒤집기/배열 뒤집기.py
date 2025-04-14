def solution(num_list):
    answer = []
    for i in range(len(num_list)-1, -1, -1):
        answer.append(num_list[i])
    # return sorted(num_list, reverse=True)
    return answer