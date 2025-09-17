import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 벨만 포드
// 14% X
public class Main {
	static int N, A, B, M;
	static long[] dist;
	static int[] get_money;
	static Edge[] edges;
	static int nINF = Integer.MIN_VALUE;
	static boolean cycle[];
	
	static class Edge {
		int from, to, w;

		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}
	
	static boolean bellmanford(int start) {
		dist[start] = get_money[start]; // 시작 노드에서는 도시를 방문해서 얻는 돈이 있음.
		boolean update = false;
		
		for(int i = 0; i < N; i++) {
			update = false;
			for(int edge_idx = 0; edge_idx < M; edge_idx++) {
				int cur = edges[edge_idx].from;
				int next = edges[edge_idx].to;
				int w = edges[edge_idx].w;
				
				if(dist[cur] == nINF) {
					continue;
				}
				
				// 간선을 타면
				// 출발 노드 값 + 다음 노드에 방문할때 받는 돈 + 다음 노드까지 갈때 비용
				// vs 다음 노드까지의 최대 거리값
				if(dist[cur] + w + get_money[next] > dist[next]) {
					dist[next] = dist[cur] + w + get_money[next];
					update = true; // 양의 사이클
					
					if(i == N-1) {
						cycle[cur] = true;
					}
				}
			}
//			System.out.println(Arrays.toString(dist));
		}
		
		return update;
	}
	
	// bfs :간선을 기준으로 도착지점까지 방문 가능하면 true
	static boolean canReach() {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			if(cycle[i]) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == B) return true;
			
			for(Edge e: edges) {
				if(e.from == cur && !visited[e.to]) {
					q.add(e.to);
					visited[e.to] = true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new long[N];
		get_money = new int[N]; // 각 도시에 방문할때마다 벌수있는 돈
		edges = new Edge[M];
		cycle = new boolean[N]; // 사이클이 만들어진다면 도착지점에 영향을 미치는지 확인하기위한 방문 배열
		
		Arrays.fill(dist, nINF);
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 방문하면 쓰는 비용이므로 음수로 저장 해야함
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			get_money[i] = Integer.parseInt(st.nextToken());
		}
		
		if(bellmanford(A) && canReach()) { 
				System.out.println("Gee"); // 갱신되면 양의 사이클이 생기므로
		} else if(dist[B] == nINF){
			System.out.println("gg"); // 도착하는것이 불가능 할때
		} else System.out.println(dist[B]);
//		System.out.println(Arrays.toString(dist));
	}
}
