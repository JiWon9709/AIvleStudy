import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Solution
{
	/**
	 * 입력: N*N
	 * 상하좌우 다른방으로 이동 -> 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 1 더커야함
	 * 어느 방에서 출발해야 많은 개수의 방을 이동할수 있는지 구하기
	 * 
	 * 완탐 , 백트래킹 => N <= 10^3 이므로 bfs ?
	 * 모든 위치를 돌면서 bfs, q 사용
	 * 만약 현재 값보다 1이 크면 방문처리 + 큐에 추가
	 * 방문 할때마다 cnt + 1
	 * 
	 * @param args
	 * @throws Exception
	 */
	private static int T, N, max_d, min_room, cnt;
	private static int[][] room;
	private static int[] dx = {0, -1, 0, 1}; // 하, 좌, 상, 우
	private static int[] dy = {1, 0, -1, 0};
	private static boolean[][] visited;
	
	public static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur_pos = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int cur_x = cur_pos[0] + dx[d];
				int cur_y = cur_pos[1] + dy[d];
				
				if(cur_x >= 0 && cur_x < N && cur_y >= 0 && cur_y < N) {
					if(!visited[cur_x][cur_y] && room[cur_x][cur_y] - room[cur_pos[0]][cur_pos[1]] == 1) {
						visited[cur_x][cur_y] = true;
						cnt++;
						q.add(new int[] {cur_x, cur_y});
					}
				}
			}
		}
		
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max_d = 0;
			min_room = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new boolean[N][N]; // 모든 셀마다 bfs 돌고
					cnt = 1; // 방문 횟수 초기화
					bfs(i, j);
					if(max_d < cnt) {
						max_d = cnt; // cnt 값중 가장 큰값을 비교
						min_room = room[i][j];
					}
					else if(max_d == cnt) {
						min_room = Math.min(min_room, room[i][j]); // 이동할수 있는 방의 개수가 최대인 방이 여러개면 가장 작은것 출력
					}
				}
			}
            System.out.println("#" + test_case+" " + min_room + " " + max_d);
		}
	}
}

/**
 * 
1
4
13 2 14 12
10 16 6 5
1 8 3 15
7 11 4 9
==== 결과 3 2
1
4
10 16 13 15 
3  1  6  8 
12 7  14 9 
2  5  4  11
=== #9 4 2
 */