from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque()
    for i in range(len(priorities)):
        if i == location:
            q.append((priorities[i], 1))
        else:
            q.append((priorities[i], 0))
    
    arr = []
    while q:
        node, flag = q.popleft()
        
        if q and node < max(p for p, _ in q):
            q.append((node, flag))
        else:
            arr.append((node, flag))
            
    for i in range(len(arr)):
        if arr[i][1] == 1:
            return i+1