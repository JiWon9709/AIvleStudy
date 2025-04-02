def solution(numer1, denom1, numer2, denom2):
    answer = []
    d = denom1 * denom2
    n = numer1*denom2 + numer2*denom1
    # print(n, d)
#     if n % d == 0:
        
#         return [n, d]
#     else:
    small = 0
    if n > d:
        small = d
    else:
        small = n
    # print(n, d)
    for i in range(small+1, 1, -1):
        if n % i == 0 and d % i == 0:
            n //= i
            d //= i
    return [n, d]
    # return answer