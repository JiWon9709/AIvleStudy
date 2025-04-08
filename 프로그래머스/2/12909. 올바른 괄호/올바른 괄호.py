def solution(s):
    answer = True
    stack = list(s)
    arr = [] # 뺀 stack을 담을 리스트
    while stack:
        node = stack.pop()
        if node == ")":
            arr.append(')')
            continue
        elif node == "(" and len(arr) > 0:
            arr.pop()
            continue
        else:
            return False
    if len(arr) > 0:
        return False
    return True