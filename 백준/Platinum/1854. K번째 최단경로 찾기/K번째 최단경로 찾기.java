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
 * 1. 플로이드 워샬로 모든 경로 저장 -> 1000 * 1000 * 1000 = 10의 9승
 * 2. 다익스트라로 모든 경로 저장 : pq에 모든 경로를 저장해서 k번째까지 poll
 */
public class Main {
	static int min, n;
	static int[][] dist;
	static int INF = 1000000000; // Integer.MAX_VALUE
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static void print() {
		for(int i = 1; i <= n; i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
		System.out.println("------------------");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		int k = Integer.parseInt(st.nextToken()); // k 번째 최단 경로 -> 각 행마다의 k 번째 최단경로
		
		ArrayList<Edge>[] edges = new ArrayList[n+1];
//		dist = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
//			
//			Arrays.fill(dist[i], INF);
//			dist[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
//			dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			edges[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
		for(int i = 1; i <= n; i++) {
			dist[i] = new PriorityQueue<>((a, b) -> b - a); // 최대 힙
		}
		
		pq.offer(new Edge(1, 0));
		dist[1].offer(0);
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int now = cur.to;
			
			for(Edge next: edges[now]) {
				int add_dist = cur.weight + next.weight;
				
				if(dist[next.to].size() < k) {
					dist[next.to].offer(next.weight + cur.weight);
					pq.offer(new Edge(next.to, next.weight + cur.weight));
				} else if(dist[next.to].peek() > add_dist) {
					dist[next.to].poll();
					dist[next.to].offer(next.weight + cur.weight);
					pq.offer(new Edge(next.to, next.weight + cur.weight));
				}
			}
			
		}
		
//		for(int i = 1; i <= n; i++) {
//			System.out.println(dist[i].toString());
//		}
		
		for(int i = 1; i <= n; i++) {
//			for(int idx = k; idx > 0; idx--) {
//				if(!dist[i].isEmpty())
//					dist[i].poll();
//			}
			
			if(dist[i].size() < k) System.out.println(-1);
			else System.out.println(dist[i].peek());
		}
		
		
	}

}

