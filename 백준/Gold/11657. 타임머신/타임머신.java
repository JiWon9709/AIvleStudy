import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 방향 그래프, 간선의 최단 경로
 * 벨만 포드
 */
public class Main {
	static int min, N, M;
	static long[] dist;
	static Edge[] edges;
	static int INF = Integer.MAX_VALUE; // Integer.MAX_VALUE
	
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
	
	static boolean bellmanford(int n) {
		dist[n] = 0;
		
		for(int i = 1; i <= N; i++) { // 한 정점에서
			for(int edge_idx = 0; edge_idx < M; edge_idx++) { // 간선들 모두 체크해보기
				int cur = edges[edge_idx].from;
				int next = edges[edge_idx].to;
				int w = edges[edge_idx].weight;
				
				if(dist[cur] == INF) continue;
				
				if(dist[cur] + w < dist[next]) {
					dist[next] = dist[cur] + w;
					
					if(i == N) return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		
		edges = new Edge[M];
		dist = new long[N+1];

		Arrays.fill(dist, INF);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 음의 사이클이 발생했을때 -1
		if(bellmanford(1)) {
			System.out.println(-1);
		} else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == INF) {
					System.out.println(-1);
				}
				else System.out.println(dist[i]);
			}
		}
		
	}

}

