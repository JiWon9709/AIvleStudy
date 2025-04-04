def solution(array):
    answer = []
    cnt = []
    for i in range(len(array)):
        if array[i] not in answer:
            answer.append(array[i])
            cnt.append(1)
        else:
            for j in range(len(answer)):
                if answer[j] == array[i]:
                    cnt[j] += 1
                    break
    
    max_idx = 0
    cnt_idx = 0 # 최빈값 개수를 세기 위한 변수
    for i in range(len(cnt)):
        if cnt[max_idx] < cnt[i]:
            max_idx = i
            cnt_idx = 1
        elif cnt[max_idx] == cnt[i]:
            cnt_idx += 1
        
    if cnt_idx > 1:
        return -1
    else:
        return answer[max_idx]