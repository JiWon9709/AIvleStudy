def solution(N, number):
    if N == number:
        return 1
    # N의 사용횟수에 따라 생각해보자
    dp = [set() for _ in range(9)]
    dp[1].add(N)
    i = 2
    while i < 9:
        tmp = ''
        for _ in range(i):
            tmp += str(N)
        if int(tmp) == number:
            return i
        dp[i].add(int(tmp))
        for j in range(1, i):
            for a in dp[i-j]:
                for b in dp[j]:
                    if (a + b == number):
                        return i
                    if (a - b == number) or b - a == number:
                        return i
                    if b != 0:
                        dp[i].add(a//b)
                        if (a // b == number):
                            return i
                    if (a * b == number):
                        return i
                    dp[i].add(a+b)
                    dp[i].add(a-b)
                    dp[i].add(b-a)
                    dp[i].add(a*b)
        i += 1
    return -1