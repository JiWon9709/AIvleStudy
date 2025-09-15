import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int min, N;
	static int[][] dj;
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
		for(int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(dj[i]));
		}
		System.out.println("------------------");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine()); // 시작
		
		ArrayList<Edge>[] edgelist = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			edgelist[i] = new ArrayList<>();
		}
	
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
//			dj[start][end] = Math.min(dj[start][end], weight);
			edgelist[start].add(new Edge(end, weight));
		}
		
		//print();
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[K] = 0;
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(K, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int now = cur.to;
			
			for(Edge e: edgelist[now]) {
				int next = e.to;
				
				if(dist[next] < e.weight) continue;
				
				if(dist[next] > dist[now] + e.weight) {
					dist[next] = dist[now] + e.weight;
					pq.offer(new Edge(next, dist[next]));
				}
			}
		}
		
//		for(int k = 1; k <= N; k++) {
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= N; j++) {
//					if(dj[i][j] > dj[i][k] + dj[k][j]) {
//						dj[i][j] = dj[i][k] + dj[k][j];
//					}
//				}
//			}
//		}
		
		//print();
		for(int i = 1; i <= V; i++) {
			if(dist[i] != INF) System.out.println(dist[i]);
			else System.out.println("INF");
		}
			
	}

}

