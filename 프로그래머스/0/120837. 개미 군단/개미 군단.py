def solution(hp):
    answer = 0
    # 23 = 5 * 4 + 3 * 1
    answer += hp // 5
    hp -= (hp // 5) * 5
    answer += hp // 3
    hp -= (hp // 3) * 3
    answer += hp
    return answer