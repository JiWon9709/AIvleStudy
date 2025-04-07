# from collections import permutations
def solution(nums):
    answer = 1
    # 3 1 2 3
    # 3 -2마리
    # 1 -1마리
    # 2 -1마리
    # n / 2 마리 가져가기 = 6가지 방법
    # 다양한 종류의 폰켓몬 선택
    n = len(nums) // 2
    res = []
    dict = {}
    for i in nums:
        if i not in dict:
            dict[i] = 1
        else:
            dict[i] += 1
    
    k = list(dict.keys())
    k.sort()
    print(k)
    for i in range(n, 0, -1):
        # 최대 n개부터 시작
        # dict의 키의 개수가 > n 이면 최대값은 n
        if len(k) >= i:
            return i
        # 최소 개수가 적은 만큼 빼기
        
    return answer