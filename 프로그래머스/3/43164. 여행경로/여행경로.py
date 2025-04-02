def solution(tickets):
    tickets.sort(key=lambda x: x[1])  # 도착지를 기준으로 사전순 정렬
    visited = [0] * len(tickets)  # 방문 여부 체크 배열
    path = ["ICN"]  # 경로 저장 리스트

    def dfs(current):
        if len(path) == len(tickets) + 1:  # 모든 티켓을 사용한 경우
            return True

        for i, (src, dst) in enumerate(tickets):
            if not visited[i] and src == current:  # 방문하지 않은 티켓 사용
                visited[i] = 1
                path.append(dst)

                if dfs(dst):  # 다음 목적지 탐색
                    return True  # 경로를 찾았으면 종료
                
                # 백트래킹: 경로가 유효하지 않으면 되돌아감
                visited[i] = 0
                path.pop()

        return False  # 더 이상 진행할 수 없는 경우
    
    dfs("ICN")  # DFS 탐색 시작
    return path  # 찾은 경로 반환
