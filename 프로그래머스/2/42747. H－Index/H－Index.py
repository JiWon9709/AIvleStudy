def solution(citations):
    n = len(citations)
    citations.sort()
    h = citations[-1]
    while h >= 0:
        num = 0
        for i in range(n-1, -1, -1):
            # print('i:',i,'h:', h)
            if n < h:
                break
            else:
                if citations[i] >= h:
                    num += 1
                else:
                    break
                    # if num >= h and n - num <= h:
                    #     return h
                    break
        if num >= h and n - num <= h:
            return h
        h -= 1
    # return h