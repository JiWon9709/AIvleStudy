import java.awt.Point;
import java.io.*;
import java.util.*;

import javax.management.Query;

/**
 * 1. bfs로 섬찾기
 * 2. 각 섬까지 갈수있는 간선들 구하기
 * 3. MST 구하기
 * 
 */
public class Main {
	static int parents[];
	static int N, M;
	static boolean[][] visited;
	static int[][] graph;
	static ArrayList<ArrayList<int[]>> islandList; // 1 -> (좌표)
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	
	static class Edge {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int find(int x) {
		if(x == parents[x]) return x;
		return find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			parents[parentA] = parentB;
			return true;
		}
		return false;
	}
	static boolean is_valid(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M) return true;
		return false;
	}
	
	static void bfs(int x, int y, int n) {
		
		Queue<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> islandPoints = new ArrayList<>();
		
		q.add(new int[] {x, y});
		islandPoints.add(new int[] {x, y});
		visited[x][y] = true;
		graph[x][y] = n;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = point[0] + dx[d];
				int ny = point[1] + dy[d];
				if(!is_valid(nx, ny)) continue;
				if(!visited[nx][ny] && graph[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					islandPoints.add(new int[] {nx, ny});
					graph[nx][ny] = n;
				}
			}
		}
		
		// 이어진 섬을 다 찾으면 graph 에 표시
		// 좌표들 모은거 다 islandList에 저장 
		islandList.add(islandPoints);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		List<Edge> edgeList = new ArrayList<>();
		
		for(int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 찾아서 넘버링
		visited = new boolean[N][M];
		islandList = new ArrayList<>();
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && graph[i][j] == 1) {
					bfs(i, j, num++);
				}
			}
		}
		
		// 간선 구하기
		// 2이상이고, 일직선으로만 간선을 만들수 있음.
		// 출발점: 각 섬의 지점에서 갈수있는 간선 만들기
		// islandList는 0부터 시작 이지만 섬은 1부터 시작 주의
		for(int island_num = 0; island_num < islandList.size(); island_num++) {
			ArrayList<int[]> islandBlock = islandList.get(island_num); // (1,0) (1,1) (2,0) (2,1)...
			
			for(int point_idx = 0; point_idx < islandBlock.size(); point_idx++) {
				int start_row = islandBlock.get(point_idx)[0];
				int start_col = islandBlock.get(point_idx)[1];
				
				for(int d= 0; d < 4; d++) {
					int nx = start_row + dx[d];
					int ny = start_col + dy[d];
					int edge_length = 0; // 2이상만 찾기위해
//					if(!is_valid(nx, ny)) continue;

					// 인접한 블록이 0 일때
					// 다리가 교차되는 경우도 있기때문에 -1로 바꿔주기
					while(is_valid(nx, ny)) {
//						if(graph[nx][ny] == -1) { // 이미 간선리스트에 들어간 부분
//							edge_length++;
//						}
//						else 
						if(graph[nx][ny] != 0) { // 다른 섬을 만날때
							if(edge_length >= 2) {
								edgeList.add(new Edge(island_num+1, graph[nx][ny], edge_length));
							}
							break;
						} else { // 0 일때 일직선상으로 직진
//							graph[nx][ny] = -1;
							edge_length++;
							nx += dx[d];
							ny += dy[d];
						}
					}
				}
			}
			
		}
		
		edgeList.sort((a, b) -> a.weight - b.weight);
		
		int islandnum = num - 1;
		parents = new int[num];
		for(int i = 1; i <= num -1; i++) {
			parents[i] = i;
		}
		
		int total = 0;
		for(Edge e: edgeList) {
			int a = e.from;
			int b = e.to;
			int w = e.weight;
			
			if(find(a) != find(b)) {
				union(a, b);
				total += w;
			}
		}
		
		int first = -1;
		boolean isconnect = true;
		for(int i = 1; i <= num -1; i++) {
			if(first == -1) {
				first = find(i);
				continue;
			}
			if(find(first) != find(i)) {
				isconnect = false;
				break;
			}
		}
		
		if(isconnect) System.out.println(total);
		else System.out.println(-1);
	}
}
