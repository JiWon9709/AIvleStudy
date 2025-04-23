def solution(emergency):
    answer = []
    sorted_emergency = sorted(emergency, reverse=True) # 76, 24, 3
    rank = {v:i+1 for i, v in enumerate(sorted_emergency)}
    # # 76:1, 24:2, 3:3
    for i in emergency:
        answer.append(rank[i])
    return answer