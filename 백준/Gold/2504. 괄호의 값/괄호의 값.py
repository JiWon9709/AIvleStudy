lst = input()
stack = []
# 1. 괄호가 올바른지 체크 false일때 return 0
# 2. 내부 괄호값부터 계산 -> 밖으로
out_str = []
tmp = 1 # 임시 변수
answer = 0
for i in range(len(lst)):
    out = lst[i]
    if lst[i] == '(':
        stack.append(lst[i])
        tmp *= 2
    elif lst[i] == '[':
        stack.append(lst[i])
        tmp *= 3
    elif lst[i] == ')':
        # 스택이 비었거나, 가장 최근에 열린괄호가 [ 이면 잘못된 괄호
        if not stack or stack[-1] == '[':
            answer = 0
            break
        # 바로 앞에 ( 가 있었다면 tmp 값을 answer에 더함
        if lst[i-1] == '(':
            answer += tmp
        # stack의 마지막 요소 '(' 를 제거하고 tmp를 2로 나눔
        stack.pop()
        tmp //= 2
    else: # ']'
        if not stack or stack[-1] == '(':
            answer = 0
            break
        if lst[i-1] == '[':
            answer += tmp
        stack.pop()
        tmp //= 3
    # print(lst[i], 'tmp:',tmp, 'answer:', answer)

if stack:
    print(0)
else:
    print(answer)