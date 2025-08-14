import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;


class Solution
{
	/**
	 * 입력: S 출발지, G 도착지
	 * 
	 * 상, 좌, 하, 우
	 * 출발지에서 도착지까지 가는 경로중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
	 * 0 : 복구작업 불필요
	 * 
	 * 지도 최대 크기 100*100
	 * BFS
	 * 시작점과 끝점이 저장되어 있음
	 * ---
	 * 다익스트라
	 * 
	 * @param args
	 * @throws Exception
	 */
	private static int T, N, min_h, cnt;
	private static int[][] map;
	private static int[][] dist; // 기록용 2차원 배열
	private static int[] dx = {0, -1, 0, 1}; // 하, 좌, 상, 우
	private static int[] dy = {1, 0, -1, 0};
	
	// bfs는 4방향 전부 탐색 -> 가장 빠른 탐색 x
	// 다익스트라 활용
	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2] - b[2]); // cost 비교
		dist = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		pq.add(new int[] {0, 0, 0}); // x, y, cost
		
		while(!pq.isEmpty()) {
			int[] cur_pos = pq.poll();
			
			int cur_x = cur_pos[0];
			int cur_y = cur_pos[1];
			int cur_cost = cur_pos[2];
			
			if(cur_x == N-1 && cur_y == N-1) {
				min_h = cur_cost;
				return ; // 도착지
			}
			
			for(int d = 0; d < 4; d++) {
				int next_x = cur_pos[0] + dx[d];
				int next_y = cur_pos[1] + dy[d];
				
				if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N) {
					if(dist[next_x][next_y] > cur_cost + map[next_x][next_y]) {
						dist[next_x][next_y] = map[next_x][next_y] + dist[cur_x][cur_y];
						pq.add(new int[] {next_x, next_y, dist[next_x][next_y]});
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
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for(int j = 0 ; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
			}
			
			min_h = Integer.MAX_VALUE;
			dijkstra(); // 시작점 0,0 -> 도착점 N-1, N-1
            System.out.println("#" + test_case+" " + min_h);
		}
	}
}

/**
 * 

 */