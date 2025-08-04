import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static class Node {
		private int to;
		private int weight;

		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static int[] dijkstra(int start, List<List<Node>> graph) {
		int v = graph.size() -1; // 노드 수
		int[] dist = new int[v+1];
		boolean[] visited = new boolean[v+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
//		visited[0] = true;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
//			if(dist[cur.to] < cur.weight) continue;
			for(Node next: graph.get(cur.to)) {
				if(!visited[next.to] && dist[next.to] > dist[cur.to] + next.weight) {
					dist[next.to] = dist[cur.to] + next.weight;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int []house_type = new int[N+1];
		
		// 집 유형 0: 아무것도 아닌집, 1: A형, 2: B형
		st = new StringTokenizer(br.readLine()); // 집 유형 설정 A
		for(int i = 0; i < K; i++) {
			int type = Integer.parseInt(st.nextToken());
			house_type[type] = 1;
		}
		
		st = new StringTokenizer(br.readLine()); // 집 유형 설정 B
		for(int i = 0; i < K; i++) {
			int type = Integer.parseInt(st.nextToken());
			house_type[type] = 2;
		}
		
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0; i< N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(dest, w));
			graph.get(dest).add(new Node(start, w));
		}
		
		int[] dist;
		dist = dijkstra(J, graph);
		
		// 동물들을 같은 종류의 집에 통일
		// 총깡총깡이 A에서만 살수 있는 경우 a
		// 다음 B에서만 살 수있으면 b
		// 상관없으면 A
		// 그다음이 아무상관없는 집이 나와야한다.
		int minA = Integer.MAX_VALUE;
		int minB = Integer.MAX_VALUE;
		for(int i = 1; i< N+1; i++) {
			if(house_type[i] == 1) {
				minA = Math.min(minA, dist[i]);
			}
			else if(house_type[i] == 2) minB = Math.min(minB, dist[i]);
		}
		
		if(minA == Integer.MAX_VALUE && minB == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else if(minA <= minB) {
			System.out.println("A");
			System.out.println(minA);
		} else {
			System.out.println("B");
			System.out.println(minB);
		}
	}

}
