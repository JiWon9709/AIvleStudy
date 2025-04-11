def solution(n):
    answer = 1
    
    while n > 0:
        if (answer * 6) % n == 0:
            return answer
        else:
            answer += 1
    return answer