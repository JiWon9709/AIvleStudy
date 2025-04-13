import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    # print(scoville)
    while len(scoville) >= 2 and scoville[0] < K:
        small1 = heapq.heappop(scoville)
        small2 = heapq.heappop(scoville)
        new_sco = small1 + (small2 * 2)
        # scoville = scoville[2:]
        heapq.heappush(scoville, new_sco)
        # scoville.append(new_sco)
        answer += 1
    
    for s in scoville:
        if s < K:
            return -1
    else:
        return answer