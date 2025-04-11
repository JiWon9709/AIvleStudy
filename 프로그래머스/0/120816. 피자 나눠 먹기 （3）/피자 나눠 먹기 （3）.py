def solution(slice, n):
    answer = 1
    while answer > 0:
        if (slice * answer) // n >= 1:
            return answer
        else:
            answer += 1
    return answer