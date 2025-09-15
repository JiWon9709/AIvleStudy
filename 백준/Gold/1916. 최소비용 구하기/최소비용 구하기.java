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
//		int from;
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
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] edgelist = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			edgelist[i] = new ArrayList<>();
		}
	
		dj = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(dj[i], INF);
			dj[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			dj[start][end] = Math.min(dj[start][end], weight);
			edgelist[start].add(new Edge(end, weight));
		}
		
		//print();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		
//		for(int k = 1; k <= N; k++) {
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= N; j++) {
//					if(dj[i][j] > dj[i][k] + dj[k][j]) {
//						dj[i][j] = dj[i][k] + dj[k][j];
//					}
//				}
//			}
//		}
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int [] dist = new int[N+1];
		for(int i = 1; i <= N; i++) {
			dist[i] = INF;
		}
		
		dist[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int now = cur.to;
			
			if(cur.weight > dist[now]) continue;
			for(Edge next : edgelist[now]) {
				if(dist[next.to] > dist[now] + next.weight) {
					dist[next.to] = dist[now] + next.weight;
					pq.offer(next);
				}
			}
		}
		
		//print();

		System.out.println(dist[end]);
	}

}

